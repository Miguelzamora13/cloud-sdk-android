/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.apps

import cloud.pace.sdk.api.API
import cloud.pace.sdk.api.poi.generated.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*
import java.util.*
import cloud.pace.sdk.api.API.toIso8601
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import cloud.pace.sdk.poikit.utils.InterceptorUtils

interface UpdateAppService {

    /** Updates App with specified id **/
    @PUT("apps/{appID}")
    fun updateApp(
        @Path("appID") appID: String? = null
    ): Call<LocationBasedApp>
}

private val service: UpdateAppService by lazy {
    Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor("application/vnd.api+json", "application/vnd.api+json")).build())
        .baseUrl(API.baseUrl)
            .addConverterFactory(
                JsonApiConverterFactory.create(
                    Moshi.Builder().add(
                        ResourceAdapterFactory.builder()
                            .build()
                    )
                        .add(KotlinJsonAdapterFactory())
                        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                        .build()
                )
            )
        .build()
        .create(UpdateAppService::class.java)
}

fun API.AppsAPI.updateApp(appID: String? = null): Call<LocationBasedApp> {
    return service.updateApp(appID)
}


