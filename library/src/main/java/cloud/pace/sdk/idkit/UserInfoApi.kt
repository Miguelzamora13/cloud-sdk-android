package cloud.pace.sdk.idkit

import cloud.pace.sdk.poikit.utils.ApiException
import cloud.pace.sdk.utils.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface UserInfoService {
    @GET(".")
    fun getUserInfo(): Call<UserInfoResponse>
}

class UserInfoApiClient(userInfoEndpoint: String, accessToken: String) {
    private val service = create(userInfoEndpoint, accessToken)

    fun getUserInfo(completion: (Completion<UserInfoResponse>) -> Unit) {
        service.getUserInfo().enqueue {
            onResponse = {
                val body = it.body()
                if (it.isSuccessful && body != null) {
                    completion(Success(body))
                } else {
                    completion(Failure(ApiException(it.code(), it.message())))
                }
            }

            onFailure = {
                completion(Failure(it ?: Exception("Unknown exception")))
            }
        }
    }

    companion object {
        private fun create(userInfoUrl: String, accessToken: String): UserInfoService {
            val baseUrl = if (userInfoUrl.endsWith("/")) userInfoUrl else "$userInfoUrl/"
            return Retrofit.Builder()
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor {
                            it.proceed(
                                it.request()
                                    .newBuilder()
                                    .header(ApiUtils.ACCEPT_HEADER, "application/json")
                                    .header(ApiUtils.CONTENT_TYPE_HEADER, "application/json")
                                    .header(ApiUtils.AUTHORIZATION_HEADER, "Bearer $accessToken")
                                    .build()
                            )
                        }
                        .build())
                .baseUrl(baseUrl)
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .add(KotlinJsonAdapterFactory())
                            .build()
                    )
                )
                .build()
                .create(UserInfoService::class.java)
        }
    }
}
