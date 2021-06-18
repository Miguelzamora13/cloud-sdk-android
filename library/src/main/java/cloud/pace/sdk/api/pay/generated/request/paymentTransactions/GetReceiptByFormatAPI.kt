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

object GetReceiptByFormatAPI {

    interface GetReceiptByFormatService {
        /* Get receipt (download,file) for a single transaction in given file format */
        /* Provides the receipt that has already been sent via email (when processing the payment) as download in the provided file format.
 */
        @GET("receipts/{transactionID}.{fileFormat}")
        fun getReceiptByFormat(
            /* ID of the payment transaction */
            @Path("transactionID") transactionID: String,
            /* Format of the expected file */
            @Path("fileFormat") fileFormat: FileFormat? = null
        ): Call<Void>
    }

    /* Format of the expected file */
    enum class FileFormat(val value: String) {
        @SerializedName("png")
        @Json(name = "png")
        PNG("png"),
        @SerializedName("pdf")
        @Json(name = "pdf")
        PDF("pdf")
    }

    private val service: GetReceiptByFormatService by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(InterceptorUtils.getInterceptor("application/json", "application/json", true))
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
            .create(GetReceiptByFormatService::class.java)
    }

    fun PayAPI.PaymentTransactionsAPI.getReceiptByFormat(transactionID: String, fileFormat: FileFormat? = null) =
        service.getReceiptByFormat(transactionID, fileFormat)
}
