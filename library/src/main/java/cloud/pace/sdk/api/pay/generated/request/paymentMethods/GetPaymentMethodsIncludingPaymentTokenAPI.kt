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
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.*

object GetPaymentMethodsIncludingPaymentTokenAPI {

    interface GetPaymentMethodsIncludingPaymentTokenService {
        /* Get all payment methods and include pre-authorized payment tokens when available */
        /* This request returns all payment methods with included pre-authorized tokens.</br></br>
The list will contain the pre-authorized amount (incl. currency), the purpose PRNs, all information about the payment method, and the paymentToken that can be used to complete the payment.</br> If no payment method is associated with a pre-authorized token, the result will contain only the payment methods.</br></br> */
        @GET("payment-methods")
        fun getPaymentMethodsIncludingPaymentToken(
            @HeaderMap headers: Map<String, String>,
            @Query("include") include: Include,
            @Query("filter[purpose]") filterpurpose: PRN? = null
        ): Call<PaymentMethods>
    }

    /* This request returns all payment methods with included pre-authorized tokens.</br></br>
    The list will contain the pre-authorized amount (incl. currency), the purpose PRNs, all information about the payment method, and the paymentToken that can be used to complete the payment.</br> If no payment method is associated with a pre-authorized token, the result will contain only the payment methods.</br></br> */
    enum class Include(val value: String) {
        @SerializedName("paymentTokens")
        @Json(name = "paymentTokens")
        PAYMENTTOKENS("paymentTokens")
    }

    open class Request : BaseRequest() {

        fun getPaymentMethodsIncludingPaymentToken(
            include: Include,
            filterpurpose: PRN? = null,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<PaymentMethods> {
            val resources = listOf(PaymentMethodVendor::class.java, PaymentMethodKind::class.java, PaymentToken::class.java, PaymentMethod::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(GetPaymentMethodsIncludingPaymentTokenService::class.java)
                .getPaymentMethodsIncludingPaymentToken(
                    headers,
                    include,
                    filterpurpose
                )
        }
    }

    fun PayAPI.PaymentMethodsAPI.getPaymentMethodsIncludingPaymentToken(
        include: Include,
        filterpurpose: PRN? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().getPaymentMethodsIncludingPaymentToken(
        include,
        filterpurpose,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
