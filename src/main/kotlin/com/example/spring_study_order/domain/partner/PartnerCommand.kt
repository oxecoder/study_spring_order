package com.example.spring_study_order.domain.partner

data class PartnerCommand(
  val partnerName : String,
  val businessNo : String,
  val email : String
){
  fun toEntity() : Partner{
    return Partner(
      partnerName = this.partnerName,
      businessNo = this.businessNo,
      email = this.email
    )

  }
}
