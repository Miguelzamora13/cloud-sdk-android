/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.delivery

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.*
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
import java.util.concurrent.TimeUnit

object DeleteGasStationReferenceStatusAPI {

    interface DeleteGasStationReferenceStatusService {
        /* Deletes a reference status of a gas station */
        /* Deletes a reference status of a gas station */
        @DELETE("delivery/gas-stations/{gasStationId}/reference-status/{reference}")
        fun deleteGasStationReferenceStatus(
            /* Gas station ID */
            @Path("gasStationId") gasStationId: String,
            /* Service Provider PRN */
            @Path("reference") reference: String
        ): Call<Void>
    }

    fun POIAPI.DeliveryAPI.deleteGasStationReferenceStatus(gasStationId: String, reference: String, readTimeout: Long? = null): Call<Void> {
        val client = OkHttpClient.Builder()
                        .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/json", "application/json", true))
                        .authenticator(InterceptorUtils.getAuthenticator())

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: DeleteGasStationReferenceStatusService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(POIAPI.baseUrl)
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
                .create(DeleteGasStationReferenceStatusService::class.java)    

        return service.deleteGasStationReferenceStatus(gasStationId, reference)
    }
}
