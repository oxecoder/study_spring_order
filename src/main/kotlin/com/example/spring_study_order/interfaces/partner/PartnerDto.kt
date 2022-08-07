package com.example.spring_study_order.interfaces.partner

import com.example.spring_study_order.domain.partner.Partner
import com.example.spring_study_order.domain.partner.PartnerCommand
import com.example.spring_study_order.domain.partner.PartnerInfo
import javax.validation.constraints.NotEmpty

sealed class PartnerDto {
  // static inner class
  data class RegisterRequest(
    @NotEmpty(message = "필수 값")
    val partnerName: String,
    @NotEmpty(message = "필수 값")
    val email: String,
    @NotEmpty(message = "필수 값")
    val businessNumber: String,
  ) : PartnerDto() {
    fun toCommand(): PartnerCommand {
      return PartnerCommand(
        partnerName = this.partnerName,
        businessNo = this.businessNumber,
        email = this.email
      )
    }

  }

  data class RegisterResponse(
    val partnerToken: String,
    val partnerName: String,
    val businessNumber: String,
    val email: String,
    val status: Partner.Status,
  ) : PartnerDto() {

    constructor(info: PartnerInfo) : this(
      partnerToken = info.partnerToken,
      partnerName = info.partnerName,
      businessNumber = info.businessNo,
      email = info.email,
      status = info.status
    )

  }

}