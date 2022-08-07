package com.example.spring_study_order.domain.partner

data class PartnerInfo(
  private val id: Long,
  val partnerToken: String,
  val partnerName: String,
  val businessNo: String,
  val email: String,
  val status: Partner.Status,
) {
  constructor(partner: Partner) : this(
    id = partner.id,
    partnerToken = partner.partnerToken,
    partnerName = partner.partnerName,
    businessNo = partner.businessNo,
    email = partner.email,
    status = partner.status
  )
}
