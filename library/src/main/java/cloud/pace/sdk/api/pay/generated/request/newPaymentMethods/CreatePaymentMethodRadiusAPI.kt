/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.newPaymentMethods

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.PaymentMethod
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodKind
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodRadiusCreateBody
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodVendor
import cloud.pace.sdk.api.pay.generated.model.PaymentToken
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object CreatePaymentMethodRadiusAPI {

    interface CreatePaymentMethodRadiusService {
        /* Register a Radius Card as a payment method */
        /* By registering you allow the user to use a Radius Card as a payment method.
The payment method ID is optional when posting data.
 */
        @POST("payment-methods/radius")
        fun createPaymentMethodRadius(
            @HeaderMap headers: Map<String, String>,
            @retrofit2.http.Body body: Body
        ): Call<PaymentMethod>
    }

    /* By registering you allow the user to use a Radius Card as a payment method.
    The payment method ID is optional when posting data.
     */
    class Body {

        var data: PaymentMethodRadiusCreateBody? = null
    }

    open class Request : BaseRequest() {

        fun createPaymentMethodRadius(
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<PaymentMethod> {
            val resources = listOf(PaymentMethodVendor::class.java, PaymentToken::class.java, PaymentMethod::class.java, PaymentMethodKind::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(CreatePaymentMethodRadiusService::class.java)
                .createPaymentMethodRadius(
                    headers,
                    body
                )
        }
    }

    fun PayAPI.NewPaymentMethodsAPI.createPaymentMethodRadius(
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().createPaymentMethodRadius(
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
