package com.example.dddkotprac.order.domain

import com.example.dddkotprac.common.MoneyConverter
import com.example.dddkotprac.common.event.Events
import com.example.dddkotprac.common.model.Money
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Embedded
    val orderer: Orderer,

    @OneToMany(
        mappedBy = "order",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val orderLines: List<OrderLine>,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    var state: OrderState,

    @Embedded
    var shippingInfo: ShippingInfo,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "total_amounts")
    var totalAmounts: Money,

    @Column(name = "order_date")
    var orderDate: ZonedDateTime,

    ) {

    init {
        require(orderLines.isNotEmpty())
    }

    private val isNotShipped: Boolean
        get() = state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING


    private fun calculateTotalAmounts(): Money {
        return Money(orderLines.sumOf { it.amounts.value })
    }

    fun addShippingInfo(shippingInfo: ShippingInfo?) {
        shippingInfo?.let {
            this.shippingInfo = it
        } ?: throw IllegalArgumentException("no ShippingInfo")
    }

    fun changeShippingInfo(newShippingInfo: ShippingInfo) {
        verifyNotYetShipped()
        this.shippingInfo = newShippingInfo
        Events.raise(ShippingInfoChangedEvent(id, newShippingInfo))
    }

    fun changeShipped() {

    }

    fun cancel() {
        verifyNotYetShipped()
        this.state = OrderState.CANCELED
        Events.raise(OrderCanceledEvent(id))
    }

    private fun verifyNotYetShipped() {
        if (!isNotShipped) {
            throw IllegalStateException("already shipped")
        }
    }

    fun completePayment() {

    }

    fun shipTo(newShippingInfo: ShippingInfo) {
        changeShippingInfo(newShippingInfo)
    }
}
