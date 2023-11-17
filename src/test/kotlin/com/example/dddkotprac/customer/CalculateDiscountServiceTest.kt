package com.example.dddkotprac.customer

import com.example.dddkotprac.order.application.CalculateDiscountService
import com.example.dddkotprac.common.model.Money
import com.example.dddkotprac.order.domain.RuleDiscounter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import org.springframework.data.repository.findByIdOrNull

class CalculateDiscountServiceTest {


    // TODO why nullPointer?
//    @Test
//    fun noCustomer_thenExceptionShouldBeThrown() {
//        val stubRepo = mock(MemberRepository::class.java)
//        `when`(stubRepo.findByIdOrNull(anyLong())).thenReturn(null)
//
//
//        val stubRule = RuleDiscounter { _, _ -> Money(0) }
//
//        val calDisSvc = CalculateDiscountService(stubRepo, stubRule)
//
//        assertThrows<NoSuchElementException> {
//            calDisSvc.calculateDiscount(listOf(), 1L)
//        }
//
//    }
}