package cloud.pace.sdk.api.pay

import cloud.pace.sdk.api.fueling.FuelingAPI
import cloud.pace.sdk.api.fueling.generated.model.TransactionRequest
import cloud.pace.sdk.api.utils.EnumConverterFactory
import cloud.pace.sdk.api.utils.InterceptorUtils
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*
import java.util.concurrent.TimeUnit

object ProcessPreAuthPaymentAPI {

    interface ProcessPaymentPreAuthService {
        /* Pre Auth or Post Pay */
        /* This call supports two different flows. The *Pre Auth* flow and the *Post Pay* flow. This call will notify the user via email with a payment receipt if transaction is finished successfully. Only use after approaching, otherwise returns `403 Forbidden`.
### Pre Auth
This flow is used if a pump is having the status `locked`. A `locked` pump requires a *Pre Auth* to unlock. Only after this *Pre Auth* the pump and can be used by the user
* `carFuelType` may be passed to only unlock a certain nozzle of the pump.
  Not all pumps support this feature, and some require it. It is advised to
  always pass the desired fuel type.
### Post Pay
You can optionally provide:
* `priceIncludingVAT` and `currency` in the request body to check if the price the user has seen is still correct.
  If the values don't match, the status `409 Conflict` is returned.
* `carFuelType` may be provided but has no effect.
 */
        @POST("gas-stations/{gasStationId}/transactions")
        fun processPreAuthPayment(
            /* Gas station ID */
            @Path("gasStationId") gasStationId: String,
            @retrofit2.http.Body body: TransactionRequest
        ): Call<ResponseBody>
    }

    fun FuelingAPI.FuelingAPI.processPreAuthPayment(gasStationId: String, body: TransactionRequest, readTimeout: Long? = null): Call<ResponseBody> {
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/vnd.api+json", "application/vnd.api+json", true))
            .authenticator(InterceptorUtils.getAuthenticator())

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: ProcessPaymentPreAuthService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(FuelingAPI.baseUrl)
                .addConverterFactory(EnumConverterFactory())
                .addConverterFactory(
                    JsonApiConverterFactory.create(
                        Moshi.Builder()
                            .add(
                                ResourceAdapterFactory.builder()
                                    .build()
                            )
                            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                            .add(KotlinJsonAdapterFactory())
                            .build()
                    )
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                            .add(KotlinJsonAdapterFactory())
                            .build()
                    )
                )
                .build()
                .create(ProcessPaymentPreAuthService::class.java)

        return service.processPreAuthPayment(gasStationId, body)
    }
}
