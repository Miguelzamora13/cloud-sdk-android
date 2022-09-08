/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.policies

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.POIType
import cloud.pace.sdk.api.poi.generated.model.Policies
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

object GetPoliciesAPI {

    interface GetPoliciesService {
        /* Returns a paginated list of policies */
        /* Returns a paginated list of policies optionally filtered by poi type and/or country id and/or user id */
        @GET("policies")
        fun getPolicies(
            @HeaderMap headers: Map<String, String>,
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

    open class Request : BaseRequest() {

        fun getPolicies(
            pagenumber: Int? = null,
            pagesize: Int? = null,
            filterpoiType: POIType? = null,
            filtercountryId: String? = null,
            filteruserId: String? = null,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<Policies> {
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(POIAPI.baseUrl, additionalParameters, readTimeout)
                .create(GetPoliciesService::class.java)
                .getPolicies(
                    headers,
                    pagenumber,
                    pagesize,
                    filterpoiType,
                    filtercountryId,
                    filteruserId
                )
        }
    }

    fun POIAPI.PoliciesAPI.getPolicies(
        pagenumber: Int? = null,
        pagesize: Int? = null,
        filterpoiType: POIType? = null,
        filtercountryId: String? = null,
        filteruserId: String? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().getPolicies(
        pagenumber,
        pagesize,
        filterpoiType,
        filtercountryId,
        filteruserId,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
