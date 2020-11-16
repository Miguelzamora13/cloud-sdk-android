package cloud.pace.sdk.app

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import cloud.pace.sdk.appkit.AppKit
import cloud.pace.sdk.appkit.communication.AppCallbackImpl
import cloud.pace.sdk.appkit.model.AuthenticationMode
import cloud.pace.sdk.appkit.model.Configuration
import cloud.pace.sdk.idkit.FailedRetrievingSessionWhileAuthorizing
import cloud.pace.sdk.idkit.IDKit
import cloud.pace.sdk.idkit.OIDConfiguration
import cloud.pace.sdk.poikit.POIKit
import cloud.pace.sdk.utils.DeviceUtils
import cloud.pace.sdk.utils.Environment
import cloud.pace.sdk.utils.Failure
import cloud.pace.sdk.utils.Success
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var appUrl = PAYMENT_APP_URL
    private var radioButtonId = R.id.radio_start_activity_for_result
    private var lastLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }

        IDKit.setup(
            this, OIDConfiguration(
                authorizationEndpoint = "YOUR_AUTHORIZATION_ENDPOINT",    // TODO: Replace with your authorization endpoint
                tokenEndpoint = "YOUR_TOKEN_ENDPOINT",    // TODO: Replace with your token endpoint
                clientId = "YOUR_CLIENT_ID",    // TODO: Replace with your client ID
                redirectUri = "YOUR_REDIRECT_URI",    // TODO: Replace with your redirect URI (URI scheme should match `appAuthRedirectScheme` in app's build.gradle file)
            )
        )

        AppKit.setup(
            this, Configuration(
                clientAppName = "PACECloudSDKExample",
                clientAppVersion = BuildConfig.VERSION_NAME,
                clientAppBuild = BuildConfig.VERSION_CODE.toString(),
                apiKey = "Missing api key",
                deviceId = getDeviceId(),
                isDarkTheme = false,
                authenticationMode = AuthenticationMode.NATIVE,
                environment = Environment.DEVELOPMENT
            )
        )

        POIKit.setup(this, Environment.DEVELOPMENT, getDeviceId())

        payment_app.setOnClickListener {
            authorize(PAYMENT_APP_URL)
        }

        fueling_app.setOnClickListener {
            authorize(FUELING_APP_URL)
        }

        reset_session.setOnClickListener {
            IDKit.resetSession()
            info_label.text = "Session reset successful"
        }

        discover_configuration.setOnClickListener {
            // TODO: Replace with your issuerUri
            IDKit.discoverConfiguration("YOUR_ISSUER_URI") {
                when (it) {
                    is Success -> {
                        authorization_endpoint.text = "Authorization endpoint: ${it.result.authorizationEndpoint}"
                        token_endpoint.text = "Token endpoint: ${it.result.tokenEndpoint}"
                        registration_endpoint.text = "Registration endpoint: ${it.result.registrationEndpoint}"
                    }
                    is Failure -> {
                        authorization_endpoint.text = it.throwable.message
                    }
                }
            }
        }

        POIKit.startLocationListener().location.observe(this) {
            val lastLocation = lastLocation
            if (lastLocation == null || lastLocation.distanceTo(it) > APP_DISTANCE_THRESHOLD) {
                AppKit.requestLocalApps { completion ->
                    if (completion is Success) {
                        AppKit.openApps(this, completion.result, false, root_layout, callback = object : AppCallbackImpl() {
                            override fun onCustomSchemeError(context: Context?, scheme: String) {
                                context ?: return
                                AlertDialog.Builder(context)
                                    .setTitle("Payment method not available")
                                    .setMessage("Sorry, this payment method is not supported by this app.")
                                    .setNeutralButton("Close") { dialog, _ ->
                                        dialog.dismiss()
                                    }
                                    .create()
                                    .show()
                            }
                        })
                    }
                }
                this.lastLocation = it
            }
        }
    }

    override fun onStart() {
        super.onStart()
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AUTHORIZE_CODE) {
            handleIntent(data)
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            radioButtonId = view.id
        }
    }

    private fun authorize(url: String) {
        appUrl = url

        if (IDKit.isAuthorizationValid()) {
            openApp()
        } else {
            when (radioButtonId) {
                R.id.radio_start_activity_for_result -> startActivityForResult(IDKit.authorize(), AUTHORIZE_CODE)
                R.id.radio_pending_intents -> IDKit.authorize(MainActivity::class.java, MainActivity::class.java)
            }
        }
    }

    private fun handleIntent(intent: Intent?) {
        if (intent != null) {
            IDKit.handleAuthorizationResponse(intent) {
                when (it) {
                    is Success -> openApp()
                    is Failure -> {
                        if (it.throwable != FailedRetrievingSessionWhileAuthorizing) {
                            info_label.text = "Unauthorized"
                        }
                    }
                }
            }
        }
    }

    private fun openApp() {
        info_label.text = "Open app"
        AppKit.openAppActivity(context = this, url = appUrl, callback = object : AppCallbackImpl() {
            override fun onTokenInvalid(onResult: (String) -> Unit) {
                IDKit.refreshToken { completion ->
                    when (completion) {
                        is Success -> completion.result?.let { onResult(it) }
                        is Failure -> info_label.text = "Refresh error: ${completion.throwable.message}"
                    }
                }
            }
        })
    }

    private fun getDeviceId(): String {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var deviceId = sharedPreferences.getString(DEVICE_ID_KEY, null)
        if (deviceId == null) {
            deviceId = DeviceUtils.generateDeviceId()
            sharedPreferences.edit().putString(DEVICE_ID_KEY, deviceId).apply()
        }

        return deviceId
    }

    companion object {
        private const val DEVICE_ID_KEY = "DEVICE_ID"
        private const val AUTHORIZE_CODE = 100
        private const val PAYMENT_APP_URL = "YOUR_PAYMENT_APP_URL"    // TODO: Replace with your payment app URL
        private const val FUELING_APP_URL = "YOUR_FUELING_APP_URL"    // TODO: Replace with your fueling app URL
        private const val APP_DISTANCE_THRESHOLD = 15
    }
}
