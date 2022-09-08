/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.user.generated.request.terms

import cloud.pace.sdk.api.request.BaseRequest
import cloud.pace.sdk.api.user.UserAPI
import cloud.pace.sdk.api.user.generated.model.Terms
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

object LatestTermsAPI {

    interface LatestTermsService {
        /* Returns the latest terms of service by serviceName */
        /* Fetches the latest terms for the given `serviceName`.
 */
        @GET("terms/latest")
        fun latestTerms(
            @HeaderMap headers: Map<String, String>,
            /* The name of the service */
            @Query("filter[serviceName]") filterserviceName: String
        ): Call<Terms>
    }

    open class Request : BaseRequest() {

        fun latestTerms(
            filterserviceName: String,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<Terms> {
            val headers = headers(false, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

            return retrofit(UserAPI.baseUrl, additionalParameters, readTimeout)
                .create(LatestTermsService::class.java)
                .latestTerms(
                    headers,
                    filterserviceName
                )
        }
    }

    fun UserAPI.TermsAPI.latestTerms(
        filterserviceName: String,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().latestTerms(
        filterserviceName,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
