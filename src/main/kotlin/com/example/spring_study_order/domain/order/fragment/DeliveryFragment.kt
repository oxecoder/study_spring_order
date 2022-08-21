package com.example.spring_study_order.domain.order.fragment

import javax.persistence.Embeddable

@Embeddable
open class DeliveryFragment(
  var receiverName: String,
  var receiverPhone: String,
  var receiverZipcode: String,
  var receiverAddress1: String,
  var receiverAddress2: String,
  var etcMessage: String,
) {
}