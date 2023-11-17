package com.example.dddkotprac.order.infra

import com.example.dddkotprac.member.query.MemberQueryService
import com.example.dddkotprac.order.domain.OrderService
import com.example.dddkotprac.order.domain.Orderer
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val memberQueryService: MemberQueryService
): OrderService {

    override fun createOrder(ordererMemberId: Long): Orderer {
        val memberData = memberQueryService.getMemberData(ordererMemberId)
        return Orderer(memberData.id, memberData.name)
    }
}