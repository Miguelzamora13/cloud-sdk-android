/*
 * PLEASE DO NOT EDIT!
 *
 * Generated by SwagGen with Kotlin template.
 * https://github.com/pace/SwagGen
 */

package cloud.pace.sdk.api.geojson

import cloud.pace.sdk.api.API

/** GeoJSON API of PACE POI */
object GeoJSONAPI {

    const val VERSION = "0.0.1"
    internal val baseUrl = "${API.baseUrl}/poi/"

    class GeoJSONAPI

    val API.geoJSON: GeoJSONAPI by lazy { GeoJSONAPI() }
}
