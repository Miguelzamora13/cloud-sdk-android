/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.stats

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.Stats
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
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import java.util.Date
import java.util.concurrent.TimeUnit

object GetStatsAPI {

    interface GetStatsService {
        /* Get statistics */
        /* Provides overall statistics */
        @GET("stats")
        fun getStats(
            @HeaderMap headers: Map<String, String>,
            /* Comma separated strings that represent the fields to be returned in the response alongside the default response */
            @Query("fields") fields: String? = null
        ): Call<Stats>
    }

    fun POIAPI.StatsAPI.getStats(
        fields: String? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ): Call<Stats> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(false, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: GetStatsService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(POIAPI.baseUrl)
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
                .create(GetStatsService::class.java)

        return service.getStats(
            headers,
            fields
        )
    }
}
