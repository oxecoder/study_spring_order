package com.example.spring_study_order.domain.partner

import com.example.spring_study_order.common.util.TokenGenerator
import com.example.spring_study_order.domain.AbstractEntity
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import org.apache.commons.lang3.StringUtils

@Entity
@Table(name = "partners")
open class Partner (
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  // 대체키
  val partnerToken: String = "",

  var partnerName: String = "",
  var businessNo: String = "",
  var email: String = "",

  /**
   * Enumerated(EnumType.String) -> ordinal 가 아닌 enum 영어가 DB에 저장됨
   */
  @Enumerated(EnumType.STRING)
  var status: Status = Status.ENABLE,

  ) : AbstractEntity() {
  constructor(partnerName: String, businessNo: String, email: String) : this(
    partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER),
    partnerName = if(StringUtils.isEmpty(partnerName)) throw java.lang.RuntimeException("피트너 네임이 없습니다") else partnerName,
    businessNo = if(StringUtils.isEmpty(businessNo)) throw java.lang.RuntimeException("피트너 비즈니스 넘버가 없습니다") else businessNo,
    email = if(StringUtils.isEmpty(email)) throw java.lang.RuntimeException("피트너 이메일이 없습니다") else email,
    status = Status.ENABLE,
  )

  fun enable() {
    this.status = Status.ENABLE
  }

  fun disable() {
    this.status = Status.DISABLE
  }

  enum class Status(
    private val description: String,
  ) {
    ENABLE("활성화"), DISABLE("비활성화"),
  }

  companion object{
    private const val PREFIX_PARTNER = "ptn_"
  }

}
