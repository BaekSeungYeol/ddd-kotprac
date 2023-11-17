package com.example.dddkotprac.order.application

import com.example.dddkotprac.catalog.domain.product.ProductRepository
import com.example.dddkotprac.common.ValidationError
import com.example.dddkotprac.common.ValidationErrorException
import com.example.dddkotprac.common.model.Money
import com.example.dddkotprac.order.domain.*
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime
import com.example.dddkotprac.common.event.Events

@Service
class PlaceOrderService(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
    private val orderService: OrderService,
) {

    @Transactional
    fun placeOrder(orderRequest: OrderRequest): Long {
        val errors = validateOrderRequest(orderRequest)
        if(errors.isNotEmpty()) {
            throw ValidationErrorException(errors)
        }

        val orderLines = mutableListOf<OrderLine>()

        orderRequest.orderProducts?.forEach { orderProduct ->
            val product  = productRepository.findByIdOrNull(orderProduct.productId) ?: throw NoSuchElementException()
            orderLines.add(OrderLine(
                productId = product.id,
                price = product.price,
                quantity = orderProduct.quantity,
            ))
        }

        val orderer = orderService.createOrder(orderRequest.ordererMemberId!!)
        val order = Order(
            orderer = orderer,
            orderLines = orderLines,
            shippingInfo = orderRequest.shippingInfo!!,
            state = OrderState.PAYMENT_WAITING,
            orderDate = ZonedDateTime.now(),
            totalAmounts = Money(orderLines.sumOf { it.amounts.value })
        )
        val savedOrder = orderRepository.save(order)

        Events.raise(OrderPlacedEvent(savedOrder.id, savedOrder.orderer, savedOrder.orderLines, savedOrder.orderDate))
        return savedOrder.id
    }

    private fun validateOrderRequest(orderRequest: OrderRequest): List<ValidationError> {
        return OrderRequestValidator().validate(orderRequest)
    }
}