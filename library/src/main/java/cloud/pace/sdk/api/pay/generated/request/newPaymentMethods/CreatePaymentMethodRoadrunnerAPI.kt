/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.newPaymentMethods

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.*
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object CreatePaymentMethodRoadrunnerAPI {

    interface CreatePaymentMethodRoadrunnerService {
        /* Register a Roadrunner Card as a payment method */
        /* By registering you allow the user to use a Roadrunner Card as a payment method.
The payment method ID is optional when posting data.
 */
        @POST("payment-methods/roadrunner")
        fun createPaymentMethodRoadrunner(
            @HeaderMap headers: Map<String, String>,
            @retrofit2.http.Body body: Body
        ): Call<PaymentMethod>
    }

    /* By registering you allow the user to use a Roadrunner Card as a payment method.
    The payment method ID is optional when posting data.
     */
    class Body {

        var data: PaymentMethodRoadrunnerCreateBody? = null
    }

    open class Request : BaseRequest() {

        fun createPaymentMethodRoadrunner(
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<PaymentMethod> {
            val resources = listOf(PaymentMethodVendor::class.java, PaymentMethodKind::class.java, PaymentToken::class.java, PaymentMethod::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(CreatePaymentMethodRoadrunnerService::class.java)
                .createPaymentMethodRoadrunner(
                    headers,
                    body
                )
        }
    }

    fun PayAPI.NewPaymentMethodsAPI.createPaymentMethodRoadrunner(
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().createPaymentMethodRoadrunner(
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
