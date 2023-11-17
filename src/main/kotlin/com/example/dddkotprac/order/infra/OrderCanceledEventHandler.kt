package com.example.dddkotprac.order.infra

import com.example.dddkotprac.order.application.RefundService
import com.example.dddkotprac.order.domain.OrderCanceledEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.event.TransactionalEventListener

@Service
class OrderCanceledEventHandler(
    private val refundService: RefundService
) {

    @Async
    @TransactionalEventListener(
        classes = [OrderCanceledEvent::class],
    )
    fun handle(event: OrderCanceledEvent) {
        refundService.refund(event.orderId)
    }
}
