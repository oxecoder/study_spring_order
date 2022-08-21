package com.example.spring_study_order.application.order

import com.example.spring_study_order.domain.notification.NotificationService
import com.example.spring_study_order.domain.order.OrderService

class OrderFacade(
  private val orderService: OrderService,
  private val notificationService: NotificationService,
) {

}