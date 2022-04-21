/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.poi.generated.model

import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "stats")
class Stats : Resource() {

    /* Number of available CoFu stations */
    var connectedFueling: Int? = null
    var connectedStationsStats: ConnectedStationsStats? = null

    class ConnectedStationsStats {

        var brands: List<Brands>? = null
        var countries: List<Countries>? = null

        class Brands {

            var brand: String? = null
            var connectedFueling: Int? = null
            var total: Int? = null
        }

        class Countries {

            var connectedFueling: Int? = null
            var countryCode: String? = null
            var total: Int? = null
        }
    }
}
