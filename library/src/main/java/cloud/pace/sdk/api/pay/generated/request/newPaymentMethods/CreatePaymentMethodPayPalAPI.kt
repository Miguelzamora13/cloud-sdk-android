/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.newPaymentMethods

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.*
import cloud.pace.sdk.api.utils.EnumConverterFactory
import cloud.pace.sdk.api.utils.InterceptorUtils
import cloud.pace.sdk.utils.toIso8601
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.Resource
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.File
import java.util.*

object CreatePaymentMethodPayPalAPI {

    interface CreatePaymentMethodPayPalService {
        /* Register PayPal as a payment method */
        /* By registering you allow the user to use PayPal as a payment method.
The payment method ID is optional when posting data.
If you provide a valid Billing Agreement ID, the payment method is created directly. Alternatively you can provide all three redirect URLs in which case the backend will create the Billing Agreement for you. Creating a Billing Agreement is a 2-step process, thus the payment method will only be created after the user approved it on the PayPal website. The approval URL in the response will point you to the correct page. After the user takes action the user is redirected to one of the three redirect URLs provided by you.
 */
        @POST("payment-methods/paypal")
        fun createPaymentMethodPayPal(
            @retrofit2.http.Body body: Body
        ): Call<PaymentMethod>
    }

    /* By registering you allow the user to use PayPal as a payment method.
    The payment method ID is optional when posting data.
    If you provide a valid Billing Agreement ID, the payment method is created directly. Alternatively you can provide all three redirect URLs in which case the backend will create the Billing Agreement for you. Creating a Billing Agreement is a 2-step process, thus the payment method will only be created after the user approved it on the PayPal website. The approval URL in the response will point you to the correct page. After the user takes action the user is redirected to one of the three redirect URLs provided by you.
     */
    class Body {

        var data: PaymentMethodPayPalCreateBody? = null
    }

    private val service: CreatePaymentMethodPayPalService by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/vnd.api+json", "application/vnd.api+json", true))
                .authenticator(InterceptorUtils.getAuthenticator())
                .build()
            )
            .baseUrl(PayAPI.baseUrl)
            .addConverterFactory(EnumConverterFactory())
            .addConverterFactory(
                JsonApiConverterFactory.create(
                    Moshi.Builder()
                        .add(ResourceAdapterFactory.builder()
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
            .create(CreatePaymentMethodPayPalService::class.java)
    }

    fun PayAPI.NewPaymentMethodsAPI.createPaymentMethodPayPal(body: Body) =
        service.createPaymentMethodPayPal(body)
}
