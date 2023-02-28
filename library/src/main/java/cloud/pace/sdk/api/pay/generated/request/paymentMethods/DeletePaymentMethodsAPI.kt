/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentMethods

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.*
import cloud.pace.sdk.api.request.BaseRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

object DeletePaymentMethodsAPI {

    interface DeletePaymentMethodsService {
        /* Delete all user's payment methods. */
        /* Deletes all payment methods of the current user.
 */
        @DELETE("payment-methods")
        fun deletePaymentMethods(
            @HeaderMap headers: Map<String, String>,
        ): Call<ResponseBody>
    }

    open class Request : BaseRequest() {

        fun deletePaymentMethods(
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<ResponseBody> {
            val headers = headers(true, "application/json", "application/json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout)
                .create(DeletePaymentMethodsService::class.java)
                .deletePaymentMethods(
                    headers
                )
        }
    }

    fun PayAPI.PaymentMethodsAPI.deletePaymentMethods(
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().deletePaymentMethods(
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
