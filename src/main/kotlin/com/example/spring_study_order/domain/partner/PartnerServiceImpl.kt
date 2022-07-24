package com.example.spring_study_order.domain.partner

import org.springframework.stereotype.Service

@Service
class PartnerServiceImpl(
  private val partnerStore : PartnerStore,
  private val partnerReader: PartnerReader
) : PartnerService {

  override fun registerPartner(command: PartnerCommand): PartnerInfo {
    // 1. command -> initPartner
    // 2. initPartner -> save to DB
    // 3. Partner -> PartnerInfo AND return

    val initPartner = command.toEntity()
    val partner : Partner = partnerStore.store(initPartner)

    return PartnerInfo(partner)
  }

  override fun getPartnerInfo(partnerToken: String): PartnerInfo {
    // 1. partnerToken -> Partner
    // 2. Partner -> PartInfo AND return
    val partner : Partner = partnerReader.getPartner(partnerToken)
    return  PartnerInfo(partner)
  }

  override fun enablePartner(partnerToken: String): PartnerInfo {
    // 1. partnerToken -> Partner
    // 2. partner.enable()

    val partner : Partner = partnerReader.getPartner(partnerToken)
    partner.enable()
    return  PartnerInfo(partner)
  }

  override fun disablePartner(partnerToken: String): PartnerInfo {
    // 1. partnerToken -> Partner
    // 2. partner.disable()
    val partner : Partner = partnerReader.getPartner(partnerToken)
    partner.disable()
    return  PartnerInfo(partner)
  }
}