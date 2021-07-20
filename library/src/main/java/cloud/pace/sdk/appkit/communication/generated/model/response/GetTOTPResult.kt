//
// Generated by KotlinPoet:
// https://github.com/square/kotlinpoet
//    
// Please do not edit!
//
package cloud.pace.sdk.appkit.communication.generated.model.response

import kotlin.Int
import kotlin.String

public data class GetTOTPResponse(
  public val totp: String,
  public val biometryMethod: String
) : ResponseBody()

public data class GetTOTPError(
  public val message: String? = null
) : ResponseBody()

public class GetTOTPResult private constructor(
  status: Int,
  body: ResponseBody?
) : Result(status, body) {
  public constructor(success: Success) : this(200, success.response)

  public constructor(failure: Failure) : this(failure.statusCode.code, failure.response)

  public class Success(
    public val response: GetTOTPResponse
  )

  public class Failure(
    public val statusCode: StatusCode,
    public val response: GetTOTPError
  ) {
    public enum class StatusCode(
      public val code: Int
    ) {
      BadRequest(400),
      Unauthorized(401),
      NotFound(404),
      MethodNotAllowed(405),
      RequestTimeout(408),
      InternalServerError(500),
      ;
    }
  }
}
