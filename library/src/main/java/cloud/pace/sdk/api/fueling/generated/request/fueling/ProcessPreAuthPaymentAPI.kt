package cloud.pace.sdk.api.fueling.generated.request.fueling

import cloud.pace.sdk.api.fueling.FuelingAPI
import cloud.pace.sdk.api.fueling.generated.model.TransactionRequest
import cloud.pace.sdk.api.request.BaseRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path

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
            @HeaderMap headers: Map<String, String>,
            /* Gas station ID */
            @Path("gasStationId") gasStationId: String,
            @retrofit2.http.Body body: TransactionRequest
        ): Call<ResponseBody>
    }

    open class Request : BaseRequest() {

        fun processPreAuthPayment(
            gasStationId: String,
            body: TransactionRequest,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<ResponseBody> {
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(FuelingAPI.baseUrl, additionalParameters, readTimeout)
                .create(ProcessPaymentPreAuthService::class.java)
                .processPreAuthPayment(
                    headers,
                    gasStationId,
                    body
                )
        }
    }

    fun FuelingAPI.FuelingAPI.processPreAuthPayment(
        gasStationId: String,
        body: TransactionRequest,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().processPreAuthPayment(
        gasStationId,
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
