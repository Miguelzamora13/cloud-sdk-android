/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.delivery

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.ReferenceStatusBody
import cloud.pace.sdk.api.request.BaseRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

object PutGasStationReferenceStatusAPI {

    interface PutGasStationReferenceStatusService {
        /* Creates or updates a reference status of a gas station */
        /* Creates or updates a reference status of a gas station */
        @PUT("delivery/gas-stations/{gasStationId}/reference-status/{reference}")
        fun putGasStationReferenceStatus(
            @HeaderMap headers: Map<String, String>,
            /* Gas station ID */
            @Path("gasStationId") gasStationId: String,
            /* Service Provider PRN */
            @Path("reference") reference: String,
            @retrofit2.http.Body body: Body
        ): Call<ResponseBody>
    }

    /* Creates or updates a reference status of a gas station */
    class Body {

        var data: ReferenceStatusBody? = null
    }

    open class Request : BaseRequest() {

        fun putGasStationReferenceStatus(
            gasStationId: String,
            reference: String,
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<ResponseBody> {
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(POIAPI.baseUrl, additionalParameters, readTimeout)
                .create(PutGasStationReferenceStatusService::class.java)
                .putGasStationReferenceStatus(
                    headers,
                    gasStationId,
                    reference,
                    body
                )
        }
    }

    fun POIAPI.DeliveryAPI.putGasStationReferenceStatus(
        gasStationId: String,
        reference: String,
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().putGasStationReferenceStatus(
        gasStationId,
        reference,
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
