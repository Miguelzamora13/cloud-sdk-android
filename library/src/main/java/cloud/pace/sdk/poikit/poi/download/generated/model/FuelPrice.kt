/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.model

import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource
import com.squareup.moshi.Json
import java.util.*

@JsonApi(type = "fuelPrice")
class FuelPrice : Resource() {
   var currency: Currency? = null
   var fuelType: Fuel? = null
/** per liter **/
   var price: Double? = null
   var productName: String? = null
/** Time of FuelPrices last update iso8601 with microseconds UTC **/
   var updatedAt: Date? = null
}
