package com.example.dddkotprac.service

import com.example.dddkotprac.order.domain.OrderRepository
import com.example.dddkotprac.order.domain.ShippingInfo
import org.springframework.data.repository.findByIdOrNull

class ChangeOrderService(
    private val orderRepository: OrderRepository
) {

    fun changeShippingInfo(orderId: Long, newShippingInfo: ShippingInfo, useNewShippingAddrAsMemberAddr: Boolean) {
        val order = orderRepository.findByIdOrNull(orderId) ?: throw NoSuchElementException()

        order.shipTo(newShippingInfo)

        if(useNewShippingAddrAsMemberAddr) {
//            member = findMember(order.orderer)
//            member.changeAddress(newShippingInfo.address)
        }
    }
}