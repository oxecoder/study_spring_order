package com.example.spring_study_order.domain.item

import com.example.spring_study_order.domain.AbstractEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "item_option_group")
open class ItemOptionGroup(
  @Id
  @GeneratedValue
  val id: Long,
  val ordering: Int,
  val itemOptionGroupName: String,

  /**
   * joinColumn을 해주어야 별도의 mapping table 없이 설정이 가능
   */
  @ManyToOne
  @JoinColumn(name = "item_id")
  val item: Item,

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = [CascadeType.PERSIST])
  val itemOptionList: List<ItemOption>,

  ) : AbstractEntity() {

}