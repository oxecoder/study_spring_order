package com.example.spring_study_order.domain.partner

data class PartnerInfo(
  private val id : Long,
  private val partnerToken : String,
  private val partnerName : String,
  private val businessNo : String,
  private val email : String,
  private val status : Partner.Status
){
  constructor(partner : Partner): this(
    id = partner.id,
    partnerToken = partner.partnerToken,
    partnerName = partner.partnerName,
    businessNo = partner.businessNo,
    email = partner.email,
    status = partner.status
  )
}
