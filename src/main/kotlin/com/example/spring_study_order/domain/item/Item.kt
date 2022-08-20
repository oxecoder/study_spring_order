package com.example.spring_study_order.domain.item

import com.example.spring_study_order.common.util.TokenGenerator
import com.example.spring_study_order.domain.AbstractEntity
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "items")
open class Item(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val itemToken: String = TokenGenerator.randomCharacterWithPrefix("prefix_item"),
  val partnerId: Long,
  val itemName: String,
  val itemPrice: Long,

  @Enumerated(EnumType.STRING)
  var status: Status = Status.PREPARE,

  /**
   * item : itemOptionGroup 은 1:N 관계
   * mappedBy : 참조되는 것중에 주인이 되는 column 선언
   */

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = [CascadeType.PERSIST])
  val itemOptionGroupList: List<ItemOptionGroup> = listOf(),

  ) : AbstractEntity() {

  fun changePrepare() {
    this.status = Status.PREPARE
  }

  fun changeOnSales() {
    this.status = Status.ON_SALES
  }

  fun changeEndOfSales() {
    this.status = Status.END_OF_SALES
  }


  public enum class Status(val description: String) {
    PREPARE("판매 준비중"),
    ON_SALES("판매중"),
    END_OF_SALES("판매종료")
  }

}