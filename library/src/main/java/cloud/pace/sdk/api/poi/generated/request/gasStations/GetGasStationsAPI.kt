/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.request.gasStations

import cloud.pace.sdk.api.poi.POIAPI
import cloud.pace.sdk.api.poi.generated.model.FuelPrice
import cloud.pace.sdk.api.poi.generated.model.GasStations
import cloud.pace.sdk.api.poi.generated.model.LocationBasedApp
import cloud.pace.sdk.api.poi.generated.model.ReferenceStatus
import cloud.pace.sdk.api.utils.EnumConverterFactory
import cloud.pace.sdk.api.utils.InterceptorUtils
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import java.util.Date
import java.util.concurrent.TimeUnit

object GetGasStationsAPI {

    interface GetGasStationsService {
        /* Query for gas stations */
        /* There are two ways to search for gas stations in a geo location. You can use either one, or none, but not both ways.
To search inside a specific radius around a given longitude and latitude provide the following query parameters:
* latitude
* longitude
* radius
To search inside a bounding box provide the following query parameter:
* boundingBox
 */
        @GET("gas-stations")
        fun getGasStations(
            @HeaderMap headers: Map<String, String>,
            /* page number */
            @Query("page[number]") pagenumber: Int? = null,
            /* items per page */
            @Query("page[size]") pagesize: Int? = null,
            /* POI type you are searching for (in this case gas stations) */
            @Query("filter[poiType]") filterpoiType: FilterpoiType? = null,
            /* Search only gas stations with fueling app available */
            @Query("filter[appType]") filterappType: List<FilterappType>? = null,
            /* Latitude in degrees */
            @Query("filter[latitude]") filterlatitude: Float? = null,
            /* Longitude in degrees */
            @Query("filter[longitude]") filterlongitude: Float? = null,
            /* Radius in meters */
            @Query("filter[radius]") filterradius: Float? = null,
            /* Bounding box representing left, bottom, right, top in degrees. The query parameters need to be passed 4 times in exactly the order left, bottom, right, top.
<table> <tr><th>#</th><th>Value</th><th>Lat/Long</th><th>Range</th></tr> <tr><td>0</td><td>left</td><td>Lat</td><td>[-180..180]</td></tr> <tr><td>1</td><td>bottom</td><td>Long</td><td>[-90..90]</td></tr> <tr><td>2</td><td>right</td><td>Lat</td><td>[-180..180]</td></tr> <tr><td>3</td><td>top</td><td>Long</td><td>[-90..90]</td></tr> </table>
 */
            @Query("filter[boundingBox]") filterboundingBox: List<Float>? = null,
            /* Reduces the opening hours rules. After compilation only rules with the action open will remain in the response. */
            @Query("compile[openingHours]") compileopeningHours: Boolean? = null,
            /* Filter by source ID */
            @Query("filter[source]") filtersource: String? = null,
            /* Comma separated strings that filter stations according to supported payment methods. */
            @Query("filter[paymentMethod]") filterpaymentMethod: String? = null
        ): Call<GasStations>
    }

    /* POI type you are searching for (in this case gas stations) */
    enum class FilterpoiType(val value: String) {
        @SerializedName("gasStation")
        @Json(name = "gasStation")
        GASSTATION("gasStation")
    }

    /* Search only gas stations with fueling app available */
    enum class FilterappType(val value: String) {
        @SerializedName("fueling")
        @Json(name = "fueling")
        FUELING("fueling")
    }

    fun POIAPI.GasStationsAPI.getGasStations(
        pagenumber: Int? = null,
        pagesize: Int? = null,
        filterpoiType: FilterpoiType? = null,
        filterappType: List<FilterappType>? = null,
        filterlatitude: Float? = null,
        filterlongitude: Float? = null,
        filterradius: Float? = null,
        filterboundingBox: List<Float>? = null,
        compileopeningHours: Boolean? = null,
        filtersource: String? = null,
        filterpaymentMethod: String? = null,
        readTimeout: Long? = null,
        additionalHeaders: Map<String, String>? = null,
        additionalParameters: Map<String, String>? = null
    ): Call<GasStations> {
        val client = OkHttpClient.Builder().addInterceptor(InterceptorUtils.getInterceptor(additionalParameters))
        val headers = InterceptorUtils.getHeaders(true, "application/vnd.api+json", "application/vnd.api+json", additionalHeaders)

        if (readTimeout != null) {
            client.readTimeout(readTimeout, TimeUnit.SECONDS)
        }

        val service: GetGasStationsService =
            Retrofit.Builder()
                .client(client.build())
                .baseUrl(POIAPI.baseUrl)
                .addConverterFactory(EnumConverterFactory())
                .addConverterFactory(
                    JsonApiConverterFactory.create(
                        Moshi.Builder()
                            .add(
                                ResourceAdapterFactory.builder()
                                    .add(FuelPrice::class.java)
                                    .add(LocationBasedApp::class.java)
                                    .add(ReferenceStatus::class.java)
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
                .create(GetGasStationsService::class.java)

        return service.getGasStations(
            headers,
            pagenumber,
            pagesize,
            filterpoiType,
            filterappType,
            filterlatitude,
            filterlongitude,
            filterradius,
            filterboundingBox,
            compileopeningHours,
            filtersource,
            filterpaymentMethod
        )
    }
}
