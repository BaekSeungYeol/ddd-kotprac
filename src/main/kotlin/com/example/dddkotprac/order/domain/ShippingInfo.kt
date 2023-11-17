package com.example.dddkotprac.order.domain

import jakarta.persistence.*

@Embeddable
data class ShippingInfo(
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "zipCode", column = Column(name = "shipping_zip_code")),
        AttributeOverride(name = "address1", column = Column(name = "shipping_addr1")),
        AttributeOverride(name = "address2", column = Column(name = "shipping_addr2"))
    )
    val address: Address,

    @Column(name = "shipping_message")
    val message: String,

    @Embedded
    val receiver: Receiver
)
