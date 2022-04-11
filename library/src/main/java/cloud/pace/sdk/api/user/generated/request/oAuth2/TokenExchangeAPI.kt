/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.user.generated.request.oAuth2

import cloud.pace.sdk.api.user.UserAPI
import cloud.pace.sdk.api.user.generated.model.*
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
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

object TokenExchangeAPI {

    interface TokenExchangeService {
        /* Exchange User  Token */
        /* Creates a PACE token for a foreign token using the OIDC token-exchange.
The token provided **must** include the following claims (see https://datatracker.ietf.org/doc/html/rfc7519#page-9):
* Claim `aud`: e.g. `"api.pace.cloud"` audience of this token is PACE API, has to match the host requested via HTTP.
  In development or other environments the URL may be different therefore, e.g. `"api.dev.pace.cloud"`.
* Claim `iss`: e.g. `"https://as.example.com"` the issuer of the token, issuer needs to be known to PACE
* Claim `iat`: e.g. `1516239022` time the token was issued
* Claim `exp`: e.g. `1516249022` identifies the expiration time on or after which the JWT MUST NOT
  be accepted for processing
* Claim `sub`: e.g. `"03836e1f-58ed-4d67-baa0-a73bf77b9d5d"` unique account id on the issuer side
* Claim `email`: e.g. `"03836e1f-58ed-4d67-baa0-a73bf77b9d5d@as.example.com"` usually an account proxy email
  (will receive SMTP mails). Usually subject ID + issuer domain to provide a unique account id.
Optionally the token may contain:
* Claim `name`: e.g. `"Jane Doe"` full name of the user (used in emails addressed to the proxy)
* Claim `given_name`: e.g. `"Jane"` given name of the user
* Claim `family_name`: e.g. `"Doe"` family name of the user
* Claim `locale`: e.g. `"de"` or `"en-US"` language code of the user (format ISO 639-1 Alpha-2 [ISO639‑1] language code in lowercase and an ISO 3166-1 Alpha-2 [ISO3166‑1] country code in uppercase, separated by a dash) defaults to `"en"`
* Claim `zoneinfo`: e.g. `"Europe/Paris"` timezone information defaults to `"Europe/Berlin"` (TZ database)
RFCs for reference:
* https://datatracker.ietf.org/doc/html/rfc8693
* https://datatracker.ietf.org/doc/html/rfc7519
 */
        @POST("protocol/openid-connect/token")
        fun tokenExchange(
            @HeaderMap headers: Map<String, String>,
            @retrofit2.http.Body body: OAuth2TokenExchange
        ): Call<OAuth2Token>
    }

    fun UserAPI.OAuth2API.tokenExchange(body: OAuth2TokenExchange, readTimeout: Long? = null, additionalHeaders: Map<String, String>? = null, additionalParameters: Map<String, String>? = null): Call<OAuth2Token> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(true, "application/x-www-form-urlencoded", "application/x-www-form-urlencoded", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: TokenExchangeService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(UserAPI.baseUrl)
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
                .create(TokenExchangeService::class.java)

        return service.tokenExchange(headers, body)
    }
}
