package com.example.dddkotprac.order.query

import com.example.dddkotprac.catalog.domain.product.QProduct.Companion.product
import com.example.dddkotprac.member.domain.QMember.Companion.member
import com.example.dddkotprac.order.domain.Order
import com.example.dddkotprac.order.domain.QOrder.Companion.order
import com.example.dddkotprac.order.domain.QOrderLine.Companion.orderLine
import com.example.dddkotprac.order.query.dto.OrderSummary
import com.example.dddkotprac.order.query.dto.OrderView
import com.example.dddkotprac.order.query.dto.QOrderSummary
import com.example.dddkotprac.order.query.dto.QOrderView
import com.querydsl.core.types.dsl.BooleanExpression
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import java.time.ZonedDateTime

class CustomOrderRepositoryImpl: QuerydslRepositorySupport(Order::class.java),  CustomOrderRepository{

    override fun findOrderView(ordererId: Long): List<OrderView> {
       return from(order, member, product)
            .innerJoin(order.orderLines, orderLine)
            .where(order.orderer.memberId.eq(ordererId)
                .and(order.orderer.memberId.eq(member.id))
                .and(orderLine.productId.eq(product.id))
            )
            .distinct()
            .select(
                QOrderView(
                   orderId = order.id,
                    state = order.state,
                    memberName = member.name,
                    memberId = member.id,
                    productName = product.name
                )
            )
           .fetch()
    }

    override fun findByIdOrderByOrderDateDescIdAsc(id: Long) : List<OrderSummary> {
        return from(order, member, product)
            .innerJoin(order.orderLines, orderLine)
            .where(order.orderer.memberId.eq(id)
                .and(order.orderer.memberId.eq(member.id))
                .and(orderLine.productId.eq(product.id))
            )
            .distinct()
            .select(
                QOrderSummary(
                    orderId = order.id,
                    ordererId = order.orderer.memberId,
                    ordererName = member.name,
                    totalAmounts = order.totalAmounts,
                    receiverName = order.shippingInfo.receiver.name,
                    state = order.state.stringValue(),
                    orderDate = order.orderDate,
                    productId = product.id,
                    productName = product.name,
                )
            )
            .fetch()
    }

    private fun orderIdEq(ordererId: Long) : BooleanExpression {
        return order.orderer.memberId.eq(ordererId)
    }

    private fun orderDateBetween(from: ZonedDateTime, to: ZonedDateTime): BooleanExpression {
        return order.orderDate.between(from,to)
    }

}
