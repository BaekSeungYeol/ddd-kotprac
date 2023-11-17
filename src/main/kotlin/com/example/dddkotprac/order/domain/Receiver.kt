package com.example.dddkotprac.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Receiver(
    @Column(name = "receiver_name")
    val name: String,
    @Column(name = "receiver_phone")
    val phoneNumber: String
) {
}