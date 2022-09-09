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
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodLogpayCreateBody
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodVendor
import cloud.pace.sdk.api.pay.generated.model.PaymentToken
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object CreatePaymentMethodLogpayAPI {

    interface CreatePaymentMethodLogpayService {
        /* Register a Logpay Card as a payment method */
        /* By registering you allow the user to use a Logpay Card as a payment method.
The payment method ID is optional when posting data.
 */
        @POST("payment-methods/logpay")
        fun createPaymentMethodLogpay(
            @HeaderMap headers: Map<String, String>,
            @retrofit2.http.Body body: Body
        ): Call<PaymentMethod>
    }

    /* By registering you allow the user to use a Logpay Card as a payment method.
    The payment method ID is optional when posting data.
     */
    class Body {

        var data: PaymentMethodLogpayCreateBody? = null
    }

    open class Request : BaseRequest() {

        fun createPaymentMethodLogpay(
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<PaymentMethod> {
            val resources = listOf(PaymentMethodVendor::class.java, PaymentToken::class.java, PaymentMethod::class.java, PaymentMethodKind::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(CreatePaymentMethodLogpayService::class.java)
                .createPaymentMethodLogpay(
                    headers,
                    body
                )
        }
    }

    fun PayAPI.NewPaymentMethodsAPI.createPaymentMethodLogpay(
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().createPaymentMethodLogpay(
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
