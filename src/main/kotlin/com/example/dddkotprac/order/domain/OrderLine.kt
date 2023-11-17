package com.example.dddkotprac.order.domain

import com.example.dddkotprac.common.MoneyConverter
import com.example.dddkotprac.common.model.Money
import jakarta.persistence.*

@Entity
class OrderLine(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = 0,

    @Column(name = "product_id")
    private var productId: Long,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "price")
    private val price: Money,

    @Column(name = "quantity")
    private val quantity: Int,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "amounts")
    var amounts: Money
) {

    constructor(productId: Long, price: Money, quantity: Int)
            : this(productId = productId, price = price, quantity = quantity, amounts = price * quantity) {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private val order: Order? = null


    fun getAmounts() {

    }
}