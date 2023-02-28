/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentTokens

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.*
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object AuthorizePaymentTokenAPI {

    interface AuthorizePaymentTokenService {
        /* Authorize a payment using the payment method */
        /* When successful, returns a paymentToken value. */
        @POST("payment-methods/{paymentMethodId}/authorize")
        fun authorizePaymentToken(
            @HeaderMap headers: Map<String, String>,
            /* ID of the paymentMethod */
            @Path("paymentMethodId") paymentMethodId: String,
            @retrofit2.http.Body body: Body
        ): Call<PaymentToken>
    }

    /* When successful, returns a paymentToken value. */
    class Body {

        var data: PaymentTokenCreateBody? = null
    }

    open class Request : BaseRequest() {

        fun authorizePaymentToken(
            paymentMethodId: String,
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<PaymentToken> {
            val resources = listOf(PaymentMethodVendor::class.java, PaymentMethodKind::class.java, PaymentToken::class.java, PaymentMethod::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(AuthorizePaymentTokenService::class.java)
                .authorizePaymentToken(
                    headers,
                    paymentMethodId,
                    body
                )
        }
    }

    fun PayAPI.PaymentTokensAPI.authorizePaymentToken(
        paymentMethodId: String,
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().authorizePaymentToken(
        paymentMethodId,
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
