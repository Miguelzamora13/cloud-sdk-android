/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.policies

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.Policy
import cloud.pace.sdk.api.poi.generated.model.PolicyBody
import cloud.pace.sdk.api.request.BaseRequest
import retrofit2.Call
import retrofit2.http.*

object CreatePolicyAPI {

    interface CreatePolicyService {
        /* Creates a new policy */
        /* Creates a new policy */
        @POST("policies")
        fun createPolicy(
            @HeaderMap headers: Map<String, String>,
            @retrofit2.http.Body body: Body
        ): Call<Policy>
    }

    /* Creates a new policy */
    class Body {

        var data: PolicyBody? = null
    }

    open class Request : BaseRequest() {

        fun createPolicy(
            body: Body,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<Policy> {
            val headers = headers(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(POIAPI.baseUrl, additionalParameters, readTimeout)
                .create(CreatePolicyService::class.java)
                .createPolicy(
                    headers,
                    body
                )
        }
    }

    fun POIAPI.PoliciesAPI.createPolicy(
        body: Body,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().createPolicy(
        body,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
