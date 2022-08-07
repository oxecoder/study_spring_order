package com.example.spring_study_order.application.partner

import com.example.spring_study_order.domain.notification.NotificationService
import com.example.spring_study_order.domain.partner.PartnerCommand
import com.example.spring_study_order.domain.partner.PartnerInfo
import com.example.spring_study_order.domain.partner.PartnerService
import org.springframework.stereotype.Service

@Service
class PartnerFacade(
  private val partnerService: PartnerService,
  private val notificationService: NotificationService,
) {

  fun registerPartner(command: PartnerCommand): PartnerInfo {
    /**
     * 1. partnerService register
     * 2. email send
     */

    val info = partnerService.registerPartner(command)
    notificationService.sendEmail(info.email, "title", "description")
    return info
  }

}