package com.example.dddkotprac.order.domain

import jakarta.persistence.AttributeOverride
import jakarta.persistence.AttributeOverrides
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Orderer(
//    @AttributeOverrides(AttributeOverride(name = "id", column = Column(name = "orderer_id")))
    @Column(name = "orderer_id")
    val memberId: Long,
    @Column(name = "orderer_name")
    val name: String
) {
}