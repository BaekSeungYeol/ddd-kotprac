package com.example.dddkotprac.order.application

import com.example.dddkotprac.member.domain.MemberRepository
import com.example.dddkotprac.common.model.Money
import com.example.dddkotprac.order.domain.OrderLine
import com.example.dddkotprac.order.domain.RuleDiscounter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CalculateDiscountService(
    private val memberRepository: MemberRepository,
//    private val ruleDiscounter: RuleDiscounter,
) {

//    fun calculateDiscount(orderLines: List<OrderLine>, customerId: Long): Money {
//        val customer = memberRepository.findByIdOrNull(customerId) ?: throw NoSuchElementException()
//        return ruleDiscounter.applyRules(customer, orderLines)
//    }

}