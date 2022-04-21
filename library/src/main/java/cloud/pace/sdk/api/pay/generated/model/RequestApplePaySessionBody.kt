/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.pay.generated.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

class RequestApplePaySessionBody {

    lateinit var type: Type
    lateinit var attributes: Attributes

    /* Unique ID of the new apple pay session. */
    var id: String? = null

    enum class Type(val value: String) {
        @SerializedName("applePayPaymentSession")
        @Json(name = "applePayPaymentSession")
        APPLEPAYPAYMENTSESSION("applePayPaymentSession")
    }

    class Attributes {

        /* Schemaless (no http/https!) validation URL obtained by the client through communicating directly with Apple Pay. */
        lateinit var validationURL: String
    }
}
