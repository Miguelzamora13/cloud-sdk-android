/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.fueling.generated.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.HasOne
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource
import java.util.*

@JsonApi(type = "paymentMethod")
class PaymentMethod : Resource() {

    var meta: Meta? = null

    var identificationString: String? = null
    /* one of sepa, creditcard, paypal, paydirekt, dkv, applepay, ... */
    var kind: String? = null
    /* indicates if the payment method kind requires two factors later on */
    var twoFactor: Boolean? = null
    /* PACE resource name(s) to payment method vendor */
    var vendorPRN: String? = null


    class Meta {

        /* Merchant name if the request was made in a way that a merchant name can be determined. For example if requesting payment methods for a specific gas station, it is the merchant name at that gas station. */
        var merchantName: String? = null
    }
}
