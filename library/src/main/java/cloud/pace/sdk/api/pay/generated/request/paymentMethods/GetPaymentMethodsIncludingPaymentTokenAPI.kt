/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentMethods

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.PRN
import cloud.pace.sdk.api.pay.generated.model.PaymentMethods
import cloud.pace.sdk.api.utils.EnumConverterFactory
import cloud.pace.sdk.api.utils.InterceptorUtils
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import java.util.Date
import java.util.concurrent.TimeUnit

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

    fun PayAPI.PaymentMethodsAPI.getPaymentMethodsIncludingPaymentToken(
        include: Include,
        filterpurpose: PRN? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ): Call<PaymentMethods> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: GetPaymentMethodsIncludingPaymentTokenService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(PayAPI.baseUrl)
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
                .create(GetPaymentMethodsIncludingPaymentTokenService::class.java)

        return service.getPaymentMethodsIncludingPaymentToken(
            headers,
            include,
            filterpurpose
        )
    }
}
