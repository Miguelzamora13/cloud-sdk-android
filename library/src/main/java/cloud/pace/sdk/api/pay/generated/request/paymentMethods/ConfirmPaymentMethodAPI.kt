/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentMethods

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

object ConfirmPaymentMethodAPI {

    interface ConfirmPaymentMethodService {
        /* Confirm and redirect to frontend */
        /* Redirect endpoint to confirm a payment method. External services redirect the user here and in turn this endpoint redirects the user to the frontend. */
        @GET("payment-methods/confirm/{token}")
        fun confirmPaymentMethod(
            /* single use token */
            @Path("token") token: String
        ): Call<Void>
    }

    private val service: ConfirmPaymentMethodService by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/json", "application/json", false))
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
            .create(ConfirmPaymentMethodService::class.java)
    }

    fun PayAPI.PaymentMethodsAPI.confirmPaymentMethod(token: String) =
        service.confirmPaymentMethod(token)
}
