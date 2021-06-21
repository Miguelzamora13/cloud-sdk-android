//
// Generated by KotlinPoet:
// https://github.com/square/kotlinpoet
//    
// Please do not edit!
//
package cloud.pace.sdk.appkit.communication.generated.model.response

import kotlin.Int
import kotlin.String
import kotlin.collections.List

public data class IntrospectResponse(
  public val version: String,
  public val operations: List<String>
) : ResponseBody()

public data class IntrospectError(
  public val message: String? = null
) : ResponseBody()

public class IntrospectResult private constructor(
  status: Int,
  body: ResponseBody?
) : Result(status, body) {
  public constructor(success: Success) : this(200, success.response)

  public constructor(failure: Failure) : this(failure.statusCode.code, failure.response)

  public class Success(
    public val response: IntrospectResponse
  )

  public class Failure(
    public val statusCode: StatusCode,
    public val response: IntrospectError
  ) {
    public enum class StatusCode(
      public val code: Int
    ) {
      BadRequest(400),
      RequestTimeout(408),
      InternalServerError(500),
      ;
    }
  }
}
