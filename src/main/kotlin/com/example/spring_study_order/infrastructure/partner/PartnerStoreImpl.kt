package com.example.spring_study_order.infrastructure.partner

import com.example.spring_study_order.domain.partner.Partner
import com.example.spring_study_order.domain.partner.PartnerStore
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Component

@Component
class PartnerStoreImpl(
  private val repository: PartnerRepository
) : PartnerStore {
  override fun store(partner: Partner): Partner {
    if(StringUtils.isEmpty(partner.partnerToken)) throw RuntimeException()
    if(StringUtils.isEmpty(partner.partnerName)) throw RuntimeException()
    if(StringUtils.isEmpty(partner.businessNo)) throw RuntimeException()
    if(StringUtils.isEmpty(partner.email)) throw RuntimeException()

    return repository.save(partner)
  }
}