package com.example.dddkotprac.order.domain

import com.example.dddkotprac.common.model.Money
import com.example.dddkotprac.member.domain.Member

fun interface RuleDiscounter {

    fun applyRules(member: Member, orderLines: List<OrderLine>): Money
}