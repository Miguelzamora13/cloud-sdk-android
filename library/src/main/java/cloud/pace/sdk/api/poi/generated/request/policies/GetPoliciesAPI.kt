/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.policies

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

object GetPoliciesAPI {

    interface GetPoliciesService {
        /* Returns a paginated list of policies */
        /* Returns a paginated list of policies optionally filtered by poi type and/or country id and/or user id */
        @GET("policies")
        fun getPolicies(
            /* page number */
            @Query("page[number]") pagenumber: Int? = null,
            /* items per page */
            @Query("page[size]") pagesize: Int? = null,
            /* Filter for poi type, no filter returns all types */
            @Query("filter[poiType]") filterpoiType: POIType? = null,
            /* Filter for all policies for the given country */
            @Query("filter[countryId]") filtercountryId: String? = null,
            /* Filter for all policies created by the given user */
            @Query("filter[userId]") filteruserId: String? = null
        ): Call<Policies>
    }

    private val service: GetPoliciesService by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/json", "application/json", true))
                .authenticator(InterceptorUtils.getAuthenticator())
                .build()
            )
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
            .create(GetPoliciesService::class.java)
    }

    fun POIAPI.PoliciesAPI.getPolicies(pagenumber: Int? = null, pagesize: Int? = null, filterpoiType: POIType? = null, filtercountryId: String? = null, filteruserId: String? = null) =
        service.getPolicies(pagenumber, pagesize, filterpoiType, filtercountryId, filteruserId)
}
