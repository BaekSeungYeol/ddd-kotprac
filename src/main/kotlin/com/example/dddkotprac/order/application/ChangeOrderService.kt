package com.example.dddkotprac.order.application

import com.example.dddkotprac.member.domain.MemberRepository
import com.example.dddkotprac.order.domain.OrderRepository
import com.example.dddkotprac.order.domain.ShippingInfo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChangeOrderService(
    private val orderRepository: OrderRepository,
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun changeShippingInfo(orderId: Long, newShippingInfo: ShippingInfo, useNewShippingAddrAsMemberAddr: Boolean) {
        val order = orderRepository.findByIdOrNull(orderId) ?: throw NoSuchElementException()
        order.changeShippingInfo(newShippingInfo)

        if(useNewShippingAddrAsMemberAddr) {
            val member = memberRepository.findByIdOrNull(order.orderer.memberId) ?: throw NoSuchElementException()
            member.changeAddress(newShippingInfo)
        }
    }

}