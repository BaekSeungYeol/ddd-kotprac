//package com.example.dddkotprac.order.infra
//
//import com.example.dddkotprac.member.domain.Member
//import com.example.dddkotprac.common.model.Money
//import com.example.dddkotprac.order.domain.OrderLine
//import com.example.dddkotprac.order.domain.RuleDiscounter
//import org.kie.api.runtime.KieContainer
//import org.springframework.stereotype.Component
//
//@Component
//class DroolsRuleEngine(
//    private val kContainer: KieContainer
//): RuleDiscounter {
//
//    override fun applyRules(member: Member, orderLines: List<OrderLine>): Money {
//        val kSession = kContainer.newKieSession("discountSession")
//        try {
//            // 코드 생략
//            return Money(0)
//        } finally {
//            kSession.dispose()
//        }
//    }
//}