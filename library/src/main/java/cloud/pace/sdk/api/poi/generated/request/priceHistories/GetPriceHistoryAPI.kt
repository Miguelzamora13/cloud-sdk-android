/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.priceHistories

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

interface GetPriceHistoryService {

    /** Get the price history for a specific gas station and fuel type on a period of time which can begin no sooner than 37 days ago; the time interval between price changes can be set to minute, hour, day, week, month or year
 **/
    @GET("gas-stations/{id}/fuel-price-histories/{fuel_type}")
    fun getPriceHistory(
        @Path("id") id: String,
        @Path("fuel_type") fuelType: Fuel? = null,
        @Query("filter[from]") filterfrom: String? = null ,
        @Query("filter[to]") filterto: String? = null ,
        @Query("filter[granularity]") filtergranularity: String? = null
    ): Call<PriceHistory>
}

private val service: GetPriceHistoryService by lazy {
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
        .create(GetPriceHistoryService::class.java)
}

fun API.PriceHistoriesAPI.getPriceHistory(id: String, fuelType: Fuel? = null, filterfrom: Date? = null, filterto: Date? = null, filtergranularity: String? = null): Call<PriceHistory> {
    return service.getPriceHistory(id, fuelType, filterfrom?.toIso8601()?.dropLast(9)?.let { it +'Z'} , filterto?.toIso8601()?.dropLast(9)?.let { it +'Z'} , filtergranularity)
}


