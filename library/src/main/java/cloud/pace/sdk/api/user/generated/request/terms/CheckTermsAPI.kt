/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.user.generated.request.terms

import cloud.pace.sdk.api.user.UserAPI
import cloud.pace.sdk.api.user.generated.model.*
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
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

object CheckTermsAPI {

    interface CheckTermsService {
        /* Checks acceptance of the terms of service for a user and a service. */
        /* Fetches the latest terms for the given UUID.
In order to identify the user any oauth2 token must be passed.
 */
        @GET("terms/check")
        fun checkTerms(
            @HeaderMap headers: Map<String, String>,
            /* The name of the service */
            @Query("filter[serviceName]") filterserviceName: FilterserviceName,
            @Query("redirectUri") redirectUri: String? = null
        ): Call<ResponseBody>
    }

    /* The name of the service */
    enum class FilterserviceName(val value: String) {
        @SerializedName("PACE ID")
        @Json(name = "PACE ID")
        PACEID("PACE ID"),
        @SerializedName("PACE Connected Fueling")
        @Json(name = "PACE Connected Fueling")
        PACECONNECTEDFUELING("PACE Connected Fueling"),
        @SerializedName("PACE Pay")
        @Json(name = "PACE Pay")
        PACEPAY("PACE Pay"),
        @SerializedName("PACE Community")
        @Json(name = "PACE Community")
        PACECOMMUNITY("PACE Community"),
        @SerializedName("PACE Car App")
        @Json(name = "PACE Car App")
        PACECARAPP("PACE Car App"),
        @SerializedName("PACE Drive App")
        @Json(name = "PACE Drive App")
        PACEDRIVEAPP("PACE Drive App")
    }

    fun UserAPI.TermsAPI.checkTerms(filterserviceName: FilterserviceName, redirectUri: String? = null, readTimeout: Long? = null, additionalHeaders: Map<String, String>? = null, additionalParameters: Map<String, String>? = null): Call<ResponseBody> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(true, "application/json", "application/json", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: CheckTermsService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(UserAPI.baseUrl)
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
                .create(CheckTermsService::class.java)

        return service.checkTerms(headers, filterserviceName, redirectUri)
    }
}
