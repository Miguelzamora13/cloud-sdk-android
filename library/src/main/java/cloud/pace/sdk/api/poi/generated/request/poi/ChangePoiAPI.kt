/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.poi

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.FuelPrice
import cloud.pace.sdk.api.poi.generated.model.GasStation
import cloud.pace.sdk.api.poi.generated.model.LocationBasedApp
import cloud.pace.sdk.api.poi.generated.model.POI
import cloud.pace.sdk.api.poi.generated.model.POIBody
import cloud.pace.sdk.api.poi.generated.model.ReferenceStatus
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object ChangePoiAPI {

    interface ChangePoiService {
        /* Updates POI with specified id (only passed attributes will be updated) */
        /* Returns POI with specified id (only passed attributes will be updated) */
        @PATCH("pois/{poiId}")
        fun changePoi(
            @HeaderMap headers: Map<String, String>,
            /* ID of the POI */
            @Path("poiId") poiId: String? = null,
            @retrofit2.http.Body body: Body
        ): Call<POI>
    }

    /* Returns POI with specified id (only passed attributes will be updated) */
    class Body {

        var data: POIBody? = null
    }

    open class Request : BaseRequest() {

        fun changePoi(
            poiId: String? = null,
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<POI> {
            val resources = listOf(ReferenceStatus::class.java, FuelPrice::class.java, LocationBasedApp::class.java, GasStation::class.java)
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(POIAPI.baseUrl, additionalParameters, readTimeout, resources)
                .create(ChangePoiService::class.java)
                .changePoi(
                    headers,
                    poiId,
                    body
                )
        }
    }

    fun POIAPI.POIAPI.changePoi(
        poiId: String? = null,
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().changePoi(
        poiId,
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
