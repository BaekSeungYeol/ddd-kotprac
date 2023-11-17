package com.example.dddkotprac.order.infra

import com.example.dddkotprac.order.domain.OrderPlacedEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Service
class OrderPlacedEventHandler {


    @Async
    @TransactionalEventListener(classes = [OrderPlacedEvent::class])
    fun handleOrderPlacedEvent(orderPlacedEvent: OrderPlacedEvent) {
        // TODO
    }
}