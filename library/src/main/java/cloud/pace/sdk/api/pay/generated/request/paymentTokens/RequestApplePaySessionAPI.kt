/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentTokens

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.ApplePaySession
import cloud.pace.sdk.api.pay.generated.model.RequestApplePaySessionBody
import cloud.pace.sdk.api.utils.EnumConverterFactory
import cloud.pace.sdk.api.utils.InterceptorUtils
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.util.Date
import java.util.concurrent.TimeUnit

object RequestApplePaySessionAPI {

    interface RequestApplePaySessionService {
        /* Requests an Apple Pay session. */
        /* Requests a new Apple Pay session including merchant validation.
The client needs to acquire the validation url beforehand.
This endpoint is pre-requisite for calling `/payment-method-kinds/applepay/authorize`.
 */
        @POST("payment-method-kinds/applepay/session")
        fun requestApplePaySession(
            @HeaderMap headers: Map<String, String>,
            @retrofit2.http.Body body: Body
        ): Call<ApplePaySession>
    }

    /* Requests a new Apple Pay session including merchant validation.
    The client needs to acquire the validation url beforehand.
    This endpoint is pre-requisite for calling `/payment-method-kinds/applepay/authorize`.
     */
    class Body {

        var data: RequestApplePaySessionBody? = null
    }

    fun PayAPI.PaymentTokensAPI.requestApplePaySession(
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ): Call<ApplePaySession> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: RequestApplePaySessionService =
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
                .create(RequestApplePaySessionService::class.java)

        return service.requestApplePaySession(
            headers,
            body
        )
    }
}
