package com.example.spring_study_order.interfaces.partner

import com.example.spring_study_order.application.partner.PartnerFacade
import com.example.spring_study_order.common.response.CommonResponse
import com.example.spring_study_order.domain.partner.PartnerCommand
import com.example.spring_study_order.domain.partner.PartnerInfo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/partners")
class PartnerApiController(
  private val partnerFacade: PartnerFacade,
) {

  @PostMapping()
  fun registerPartner(
    request: PartnerDto.RegisterRequest,
  ): CommonResponse<PartnerDto.RegisterResponse> {
    /**
     * 1. 외부에서 전달된 파라미터 (dto) -> Command, Criteria converter
     * 2. facade 호출
     * 3. CommonResponse 으로 convert and return
     *
     */

    val command = request.toCommand()
    val info = partnerFacade.registerPartner(command)
    val res = PartnerDto.RegisterResponse(info)
    return CommonResponse.success(res)
  }
}