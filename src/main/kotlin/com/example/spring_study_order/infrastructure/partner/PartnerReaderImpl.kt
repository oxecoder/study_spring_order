package com.example.spring_study_order.infrastructure.partner

import com.example.spring_study_order.domain.partner.Partner
import com.example.spring_study_order.domain.partner.PartnerReader
import org.springframework.stereotype.Component

@Component
class PartnerReaderImpl(
  private val partnerRepository: PartnerRepository
) : PartnerReader{
  override fun getPartner(token: String): Partner {
    return partnerRepository.findByPartnerToken(token).orElseThrow { RuntimeException() }
  }
}