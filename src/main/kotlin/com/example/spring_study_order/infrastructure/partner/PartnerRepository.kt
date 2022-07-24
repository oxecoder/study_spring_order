package com.example.spring_study_order.infrastructure.partner

import com.example.spring_study_order.domain.partner.Partner
import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository

interface PartnerRepository : JpaRepository<Partner, Long> {
  fun findByPartnerToken(partnerToken : String) : Optional<Partner>
}