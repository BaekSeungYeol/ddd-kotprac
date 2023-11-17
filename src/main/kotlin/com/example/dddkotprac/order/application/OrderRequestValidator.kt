package com.example.dddkotprac.order.application

import com.example.dddkotprac.common.ValidationError

class OrderRequestValidator {

    fun validate(orderRequest: OrderRequest): List<ValidationError> {
        val errors = mutableListOf<ValidationError>()
        if(orderRequest.ordererMemberId == null) {
            errors.add(ValidationError.of("ordererMemberId", "required"))
        }
        return errors
    }
}