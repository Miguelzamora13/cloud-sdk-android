/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.request.paymentTransactions

import cloud.pace.sdk.api.pay.PayAPI
import cloud.pace.sdk.api.pay.generated.model.*
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

object ListTransactionsCSVAPI {

    interface ListTransactionsCSVService {
        /* List transactions as CSV */
        /* List all transactions for the current user as csv.
 */
        @GET("transactions.csv")
        fun listTransactionsCSV(
            /* Number of the page that should be returned (sometimes referred to as "offset"). Page `0` is the first page. */
            @Query("page[number]") pagenumber: Int? = null,
            /* Page size of the currently returned page (sometimes referred to as "limit"). */
            @Query("page[size]") pagesize: Int? = null,
            /* Sort by given attribute, plus and minus are used to indicate ascending and descending order. */
            @Query("sort") sort: Sort? = null,
            /* ID of the payment transaction */
            @Query("filter[id]") filterid: String? = null,
            /* Time the transaction was created. */
            @Query("filter[createdAt]") filtercreatedAt: String? = null,
            /* Time the transaction was last updated. */
            @Query("filter[updatedAt]") filterupdatedAt: String? = null,
            /* Payment method ID of the transaction. */
            @Query("filter[paymentMethodId]") filterpaymentMethodId: String? = null,
            /* Payment method kind of the transaction. */
            @Query("filter[paymentMethodKind]") filterpaymentMethodKind: String? = null,
            /* PACE resource name of the resource, for which the payment was authorized. */
            @Query("filter[purposePRN]") filterpurposePRN: String? = null,
            /* PACE resource name - referring to the transaction purpose with provider details. */
            @Query("filter[providerPRN]") filterproviderPRN: String? = null,
            /* Product name of the fuel that was used in the transaction. */
            @Query("filter[fuel.productName]") filterfuelProductName: String? = null,
            /* Fuel type which was used in the transaction. */
            @Query("filter[fuel.type]") filterfuelType: String? = null
        ): Call<Void>
    }

    /* Sort by given attribute, plus and minus are used to indicate ascending and descending order. */
    enum class Sort(val value: String) {
        @SerializedName("id")
        @Json(name = "id")
        ID("id"),
        @SerializedName("createdAt")
        @Json(name = "createdAt")
        CREATEDAT("createdAt"),
        @SerializedName("updatedAt")
        @Json(name = "updatedAt")
        UPDATEDAT("updatedAt"),
        @SerializedName("paymentMethodId")
        @Json(name = "paymentMethodId")
        PAYMENTMETHODID("paymentMethodId"),
        @SerializedName("paymentMethodKind")
        @Json(name = "paymentMethodKind")
        PAYMENTMETHODKIND("paymentMethodKind"),
        @SerializedName("purposePRN")
        @Json(name = "purposePRN")
        PURPOSEPRN("purposePRN"),
        @SerializedName("providerPRN")
        @Json(name = "providerPRN")
        PROVIDERPRN("providerPRN"),
        @SerializedName("fuel.productName")
        @Json(name = "fuel.productName")
        FUELPRODUCTNAME("fuel.productName"),
        @SerializedName("fuel.type")
        @Json(name = "fuel.type")
        FUELTYPE("fuel.type"),
        @SerializedName("-id")
        @Json(name = "-id")
        IDDESCENDING("-id"),
        @SerializedName("-createdAt")
        @Json(name = "-createdAt")
        CREATEDATDESCENDING("-createdAt"),
        @SerializedName("-updatedAt")
        @Json(name = "-updatedAt")
        UPDATEDATDESCENDING("-updatedAt"),
        @SerializedName("-paymentMethodId")
        @Json(name = "-paymentMethodId")
        PAYMENTMETHODIDDESCENDING("-paymentMethodId"),
        @SerializedName("-paymentMethodKind")
        @Json(name = "-paymentMethodKind")
        PAYMENTMETHODKINDDESCENDING("-paymentMethodKind"),
        @SerializedName("-purposePRN")
        @Json(name = "-purposePRN")
        PURPOSEPRNDESCENDING("-purposePRN"),
        @SerializedName("-providerPRN")
        @Json(name = "-providerPRN")
        PROVIDERPRNDESCENDING("-providerPRN"),
        @SerializedName("-fuel.productName")
        @Json(name = "-fuel.productName")
        FUELPRODUCTNAMEDESCENDING("-fuel.productName"),
        @SerializedName("-fuel.type")
        @Json(name = "-fuel.type")
        FUELTYPEDESCENDING("-fuel.type")
    }

    private val service: ListTransactionsCSVService by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/vnd.api+json", "application/vnd.api+json"))
                .authenticator(InterceptorUtils.getAuthenticator())
                .build()
            )
            .baseUrl(PayAPI.baseUrl)
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
            .create(ListTransactionsCSVService::class.java)
    }

    fun PayAPI.PaymentTransactionsAPI.listTransactionsCSV(pagenumber: Int? = null, pagesize: Int? = null, sort: Sort? = null, filterid: String? = null, filtercreatedAt: Date? = null, filterupdatedAt: Date? = null, filterpaymentMethodId: String? = null, filterpaymentMethodKind: String? = null, filterpurposePRN: String? = null, filterproviderPRN: String? = null, filterfuelProductName: String? = null, filterfuelType: String? = null) =
        service.listTransactionsCSV(pagenumber, pagesize, sort, filterid, filtercreatedAt?.toIso8601()?.dropLast(9)?.let { it +'Z'} , filterupdatedAt?.toIso8601()?.dropLast(9)?.let { it +'Z'} , filterpaymentMethodId, filterpaymentMethodKind, filterpurposePRN, filterproviderPRN, filterfuelProductName, filterfuelType)
}
