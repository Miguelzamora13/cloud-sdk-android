/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.user.generated.request.federatedIdentity

import cloud.pace.sdk.api.user.UserAPI
import cloud.pace.sdk.api.user.generated.model.AccessToken
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
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.Date
import java.util.concurrent.TimeUnit

object GrantFederatedTokenAPI {

    interface GrantFederatedTokenService {
        /* Provide a token for a federated identity provider */
        /* Provides a token for the given identity provider, if the user has a valid one. Token grant is a request as per OAuth2 specification
 */
        @POST("federated-identities/{identityProvider}/token")
        fun grantFederatedToken(
            @HeaderMap headers: Map<String, String>,
            @Path("identityProvider") identityProvider: String? = null
        ): Call<AccessToken>
    }

    fun UserAPI.FederatedIdentityAPI.grantFederatedToken(
        identityProvider: String? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ): Call<AccessToken> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(false, "application/json", "application/json", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: GrantFederatedTokenService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(UserAPI.baseUrl)
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
                .create(GrantFederatedTokenService::class.java)

        return service.grantFederatedToken(
            headers,
            identityProvider
        )
    }
}
