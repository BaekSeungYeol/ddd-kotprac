package com.example.dddkotprac.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(name = "zip_code")
    val zipCode: String,
    @Column(name = "address1")
    val address1: String,
    @Column(name = "address2")
    val address2: String,
)