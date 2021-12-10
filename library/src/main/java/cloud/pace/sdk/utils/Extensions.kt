package cloud.pace.sdk.utils

import android.content.res.Resources
import android.util.TypedValue
import cloud.pace.sdk.PACECloudSDK
import cloud.pace.sdk.idkit.model.OIDConfiguration
import net.openid.appauth.ResponseTypeValues
import java.security.SecureRandom
import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts integer to density-independent pixels (dp).
 */
val Int.dp: Int get() = (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics)).toInt()

/**
 * Converts float to density-independent pixels (dp).
 */
val Float.dp: Int get() = (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)).toInt()

/**
 * Returns the UUID of an URN or null.
 */
val String.resourceUuid: String?
    get() = split(":").lastOrNull()

/**
 * Returns `true` if this nullable char sequence is not `null` or empty.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun CharSequence?.isNotNullOrEmpty(): Boolean = !isNullOrEmpty()

/**
 * Returns `true` if this nullable char sequence is not `null` or blank.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun CharSequence?.isNotNullOrBlank(): Boolean = !isNullOrBlank()

fun Date.toIso8601(): String {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).run {
        timeZone = TimeZone.getTimeZone("UTC")
        format(this@toIso8601)
    }
}

fun Date.toRfc3339Short(): String {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).run {
        timeZone = TimeZone.getTimeZone("UTC")
        format(this@toRfc3339Short)
    }
}

fun String.Companion.randomHexString(length: Int): String {
    val secureRandom = SecureRandom()
    val stringBuilder = StringBuffer()
    repeat(length) {
        stringBuilder.append(Integer.toHexString(secureRandom.nextInt()))
    }
    return stringBuilder.toString().substring(0, length)
}

fun <T> List<T>.equalsTo(other: List<T>): Boolean {
    return size == other.size && containsAll(other)
}

fun Environment.getOIDConfiguration(
    clientId: String,
    clientSecret: String? = null,
    scopes: List<String>? = null,
    redirectUri: String,
    responseType: String = ResponseTypeValues.CODE,
    additionalParameters: Map<String, String>? = null,
    authorizationEndpoint: String? = null,
    endSessionEndpoint: String? = null,
    tokenEndpoint: String? = null,
    userInfoEndpoint: String? = null,
): OIDConfiguration {
    return when (this) {
        Environment.DEVELOPMENT -> {
            OIDConfiguration.development(clientId, clientSecret, scopes, redirectUri, responseType, additionalParameters, authorizationEndpoint, endSessionEndpoint, tokenEndpoint, userInfoEndpoint)
        }
        Environment.SANDBOX -> {
            OIDConfiguration.sandbox(clientId, clientSecret, scopes, redirectUri, responseType, additionalParameters, authorizationEndpoint, endSessionEndpoint, tokenEndpoint, userInfoEndpoint)
        }
        Environment.STAGING -> {
            OIDConfiguration.staging(clientId, clientSecret, scopes, redirectUri, responseType, additionalParameters, authorizationEndpoint, endSessionEndpoint, tokenEndpoint, userInfoEndpoint)
        }
        Environment.PRODUCTION -> {
            OIDConfiguration.production(clientId, clientSecret, scopes, redirectUri, responseType, additionalParameters, authorizationEndpoint, endSessionEndpoint, tokenEndpoint, userInfoEndpoint)
        }
    }
}

val PACECloudSDK.environment: Environment
    get() = configuration.environment
