/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.user.generated.model

import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource

@JsonApi(type = "updateUserPhone")
class UpdateUserPhone : Resource() {

    /* complete phone number of the user */
    lateinit var phoneNumber: String
}
