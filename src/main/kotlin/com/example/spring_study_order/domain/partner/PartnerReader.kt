package com.example.spring_study_order.domain.partner

interface PartnerReader {
  fun getPartner(token : String) : Partner
}