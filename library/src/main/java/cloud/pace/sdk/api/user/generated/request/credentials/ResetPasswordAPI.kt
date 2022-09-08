/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.user.generated.request.credentials

import cloud.pace.sdk.api.request.BaseRequest
import cloud.pace.sdk.api.user.UserAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.HeaderMap
import retrofit2.http.PUT
import retrofit2.http.Query

object ResetPasswordAPI {

    interface ResetPasswordService {
        /* Reset password for a user. */
        /* Reset password for recover User's password.
If no recover pin is passed in the body user's payment methods will also be reset.
 */
        @PUT("user/password/reset")
        fun resetPassword(
            @HeaderMap headers: Map<String, String>,
            /* Recover pin */
            @Query("pin") pin: String? = null
        ): Call<ResponseBody>
    }

    open class Request : BaseRequest() {

        fun resetPassword(
            pin: String? = null,
            readTimeout: Long? = null,
            additionalHeaders: Map<String, String>? = null,
            additionalParameters: Map<String, String>? = null
        ): Call<ResponseBody> {
            val headers = headers(false, "application/json", "application/json", additionalHeaders)

            return retrofit(UserAPI.baseUrl, additionalParameters, readTimeout)
                .create(ResetPasswordService::class.java)
                .resetPassword(
                    headers,
                    pin
                )
        }
    }

    fun UserAPI.CredentialsAPI.resetPassword(
        pin: String? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ) = Request().resetPassword(
        pin,
        readTimeout,
        additionalHeaders,
        additionalParameters
    )
}
