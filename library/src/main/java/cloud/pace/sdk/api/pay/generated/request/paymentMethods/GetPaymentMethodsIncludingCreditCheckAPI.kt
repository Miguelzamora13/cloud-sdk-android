/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentMethods

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.PRN
import cloud.pace.sdk.api.pay.generated.model.PaymentMethod
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodKind
import cloud.pace.sdk.api.pay.generated.model.PaymentMethodVendor
import cloud.pace.sdk.api.pay.generated.model.PaymentMethods
import cloud.pace.sdk.api.pay.generated.model.PaymentToken
import cloud.pace.sdk.api.request.BaseRequest
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

object GetPaymentMethodsIncludingCreditCheckAPI {

    interface GetPaymentMethodsIncludingCreditCheckService {
        /* Get all ready-to-use payment methods for user */
        /* This request will return a list of supported payment methods for the current user that they can, in theory, use. That is, ones that are valid and can immediately be used.</br></br>
This is as opposed to the regular `/payment-methods`, which does not categorize payment methods as valid for use.</br></br>
You should trigger this when the user is approaching on a gas station with fueling support to get a list of available payment methods.</br></br>
If the list is empty, you can ask the user to add a payment method to use PACE fueling. */
        @GET("payment-methods")
        fun getPaymentMethodsIncludingCreditCheck(
            @HeaderMap headers: Map<String, String>,
            @Query("filter[status]") filterstatus: Filterstatus,
            @Query("filter[purpose]") filterpurpose: PRN? = null
        ): Call<PaymentMethods>
    }

    /* This request will return a list of supported payment methods for the current user that they can, in theory, use. That is, ones that are valid and can immediately be used.</br></br>
    This is as opposed to the regular `/payment-methods`, which does not categorize payment methods as valid for use.</br></br>
    You should trigger this when the user is approaching on a gas station with fueling support to get a list of available payment methods.</br></br>
    If the list is empty, you can ask the user to add a payment method to use PACE fueling. */
    enum class Filterstatus(val value: String) {
        @SerializedName("valid")
        @Json(name = "valid")
        VALID("valid")
    }

    open class Request : BaseRequest() {

        fun getPaymentMethodsIncludingCreditCheck(
            filterstatus: Filterstatus,
            filterpurpose: PRN? = null,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<PaymentMethods> {
            val resources = listOf(PaymentMethodKind::class.java, PaymentMethodVendor::class.java, PaymentMethod::class.java, PaymentToken::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(PayAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(GetPaymentMethodsIncludingCreditCheckService::class.java)
                .getPaymentMethodsIncludingCreditCheck(
                    headers,
                    filterstatus,
                    filterpurpose
                )
        }
    }

    fun PayAPI.PaymentMethodsAPI.getPaymentMethodsIncludingCreditCheck(
        filterstatus: Filterstatus,
        filterpurpose: PRN? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().getPaymentMethodsIncludingCreditCheck(
        filterstatus,
        filterpurpose,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
