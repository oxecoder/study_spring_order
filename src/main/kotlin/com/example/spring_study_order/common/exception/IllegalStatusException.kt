package com.example.spring_study_order.common.exception

import com.example.spring_study_order.common.response.ErrorCode

class IllegalStatusException : BaseException {
  constructor() : super(ErrorCode.COMMON_ILLEGAL_STATUS) {}
  constructor(message: String?) : super(message, ErrorCode.COMMON_ILLEGAL_STATUS) {}
}
