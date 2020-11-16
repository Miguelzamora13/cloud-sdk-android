package cloud.pace.sdk.appkit.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cloud.pace.sdk.R
import cloud.pace.sdk.appkit.app.webview.AppWebViewClient
import cloud.pace.sdk.appkit.communication.AppEventManager
import cloud.pace.sdk.appkit.communication.AppModel
import cloud.pace.sdk.utils.AppKitKoinComponent
import kotlinx.android.synthetic.main.fragment_app.*
import org.koin.android.ext.android.inject

class AppActivity : AppCompatActivity(), AppKitKoinComponent {

    private var backToFinish = true
    private val eventManager: AppEventManager by inject()
    private val appModel: AppModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        appModel.reset()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, AppFragment())
            .commit()

        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(false)
        }

        backToFinish = intent.extras?.getBoolean(BACK_TO_FINISH, true) ?: true

        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onBackPressed() {
        if (backToFinish) {
            finish()
        } else {
            appWebView.onBackPressed()
        }
    }

    override fun onDestroy() {
        appWebView.onDestroy()
        super.onDestroy()
    }

    private fun handleIntent(intent: Intent?) {
        intent ?: return

        val appLinkAction = intent.action
        val appLinkData = intent.data
        if (Intent.ACTION_VIEW == appLinkAction) {
            appLinkData?.getQueryParameter(AppWebViewClient.TO)?.let { finalRedirect ->
                eventManager.onReceivedRedirect(finalRedirect)
            }
        }
    }

    companion object {
        const val APP_URL = "APP_URL"
        const val BACK_TO_FINISH = "BACK_TO_FINISH"
    }
}
