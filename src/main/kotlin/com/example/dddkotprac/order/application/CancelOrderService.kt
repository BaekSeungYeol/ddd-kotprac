package com.example.dddkotprac.order.application

import com.example.dddkotprac.order.domain.CancelPolicy
import com.example.dddkotprac.order.domain.Canceller
import com.example.dddkotprac.order.domain.OrderNotFoundException
import com.example.dddkotprac.order.domain.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CancelOrderService(
    private val orderRepository: OrderRepository,
    private val cancelPolicy: CancelPolicy

) {

    @Transactional
    fun cancelOrder(orderId: Long, canceller: Canceller) {
       val order = orderRepository.findByIdOrNull(orderId) ?: throw OrderNotFoundException(orderId)

        if(!cancelPolicy.hasCancellationPermission(order,canceller)) {
            throw NoCancellablePermission()
        }
       order.cancel()
    }
}
