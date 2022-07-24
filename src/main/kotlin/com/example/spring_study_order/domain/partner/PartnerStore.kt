package com.example.spring_study_order.domain.partner

interface PartnerStore {
  fun store(partner : Partner) : Partner
}