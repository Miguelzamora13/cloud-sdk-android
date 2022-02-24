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

object GetTermsAPI {

    interface GetTermsService {
        /* Returns the latest terms of service by UUID */
        /* Fetches the latest terms for the given UUID.
 */
        @GET("terms/{termsId}")
        fun getTerms(
            @Path("termsId") termsId: String? = null,
            @Query("redirectUri") redirectUri: String? = null,
            @Header("Accept-Language") acceptLanguage: String? = null, 
            @Header("Accept") accept: String? = null
        ): Call<Terms>
    }

    enum class GetTermsAcceptHeader(val value: String) {
        APPLICATION_VND_API_JSON("application/vnd.api+json"),
        TEXT_HTML("text/html")
    }

    fun UserAPI.TermsAPI.getTerms(termsId: String? = null, redirectUri: String? = null, acceptLanguage: String? = null, readTimeout: Long? = null, accept: GetTermsAcceptHeader? = null, additionalHeaders: Map<String, String>? = null): Call<Terms> {
        val client = OkHttpClient.Builder()
                        .addNetworkInterceptor(InterceptorUtils.getInterceptor(null, "application/vnd.api+json", false, additionalHeaders))
                        .authenticator(InterceptorUtils.getAuthenticator())

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: GetTermsService =
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
                .create(GetTermsService::class.java)

        return service.getTerms(termsId, redirectUri, acceptLanguage, accept?.value)
    }
}
