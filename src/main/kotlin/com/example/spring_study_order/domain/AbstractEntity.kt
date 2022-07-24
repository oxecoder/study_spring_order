package com.example.spring_study_order.domain

import java.time.ZonedDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class AbstractEntity {

  @CreationTimestamp
  private val createdAt : ZonedDateTime = ZonedDateTime.now()

  @UpdateTimestamp
  private val updatedAt : ZonedDateTime = ZonedDateTime.now()
}