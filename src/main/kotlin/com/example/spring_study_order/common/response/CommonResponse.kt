package com.example.spring_study_order.common.response


data class CommonResponse<T>(
  val result: Result,
  val data: T? = null,
  val message: String? = null,
  val errorCode: String? = null,
) {

  enum class Result {
    SUCCESS, FAIL
  }

  companion object {
    fun <T> success(data: T, message: String?): CommonResponse<T> {
      return CommonResponse(
        result = CommonResponse.Result.SUCCESS,
        data = data,
        message = message
      )
    }

    fun <T> success(data: T): CommonResponse<T> {
      return success(data)
    }

    fun fail(message: String?, errorCode: String?): CommonResponse<Unit> {
      return CommonResponse(
        result = CommonResponse.Result.FAIL,
        message = message,
        errorCode = errorCode
      )
    }


    fun fail(errorCode: ErrorCode): CommonResponse<Unit> {
      return CommonResponse(
        result = CommonResponse.Result.FAIL,
        message = errorCode.getErrorMsg(),
        errorCode = errorCode.name
      )
    }

  }
}

