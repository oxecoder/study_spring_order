package com.example.spring_study_order.common.exception

import com.example.spring_study_order.common.response.ErrorCode

class EntityNotFoundException : BaseException {
  constructor() : super(ErrorCode.COMMON_INVALID_PARAMETER) {}
  constructor(message: String?) : super(message, ErrorCode.COMMON_INVALID_PARAMETER) {}
}
