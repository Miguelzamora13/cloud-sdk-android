/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.metadataFilters

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.*
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object GetMetadataFiltersAPI {

    interface GetMetadataFiltersService {
        /* Query for filterable values inside a radius */
        /* Returns filterable values around the current location on the map, within a certain radius.
For the latitude and longitude values used in the request, returns the available and unavailable values for the following fields:
  * brand
  * payment methods
  * amenities
 */
        @GET("meta")
        fun getMetadataFilters(
            @HeaderMap headers: Map<String, String>,
            /* Latitude in degrees */
            @Query("latitude") latitude: Float,
            /* Longitude in degrees */
            @Query("longitude") longitude: Float
        ): Call<Categories>
    }

    open class Request : BaseRequest() {

        fun getMetadataFilters(
            latitude: Float,
            longitude: Float,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<Categories> {
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(POIAPI.baseUrl, additionalParameters, readTimeout)
                .create(GetMetadataFiltersService::class.java)
                .getMetadataFilters(
                    headers,
                    latitude,
                    longitude
                )
        }
    }

    fun POIAPI.MetadataFiltersAPI.getMetadataFilters(
        latitude: Float,
        longitude: Float,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().getMetadataFilters(
        latitude,
        longitude,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
