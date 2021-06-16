/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.gasStations

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.*
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
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.File
import java.util.*

object GetGasStationFuelTypeNameMappingAPI {

    interface GetGasStationFuelTypeNameMappingService {
        /* Get a mapping from gas station specific fuel product name mapped to a normalized fuel type */
        /* Every gas station potential has different names for the same fuel types. This endpoint accepts the gas station's specific name and return a mapping where the specific name is mapped to a normalized version which should be globally the same across gas stations.
 */
        @GET("gas-stations/{id}/fueltype")
        fun getGasStationFuelTypeNameMapping(
            /* Gas station ID */
            @Path("id") id: String,
            /* Product Name */
            @Query("filter[productName]") filterproductName: String
        ): Call<FuelType>
    }

    private val service: GetGasStationFuelTypeNameMappingService by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/vnd.api+json", "application/vnd.api+json"))
                .authenticator(InterceptorUtils.getAuthenticator())
                .build()
            )
            .baseUrl(POIAPI.baseUrl)
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
            .create(GetGasStationFuelTypeNameMappingService::class.java)
    }

    fun POIAPI.GasStationsAPI.getGasStationFuelTypeNameMapping(id: String, filterproductName: String) =
        service.getGasStationFuelTypeNameMapping(id, filterproductName)
}
