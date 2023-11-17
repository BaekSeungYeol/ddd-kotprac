package com.example.dddkotprac.order.ui

import com.example.dddkotprac.common.ValidationErrorException
import com.example.dddkotprac.order.application.CancelOrderService
import com.example.dddkotprac.order.application.OrderRequest
import com.example.dddkotprac.order.application.PlaceOrderService
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class OrderController(
    private val placeOrderService: PlaceOrderService
) {

    @PostMapping("/order/place")
    fun order(@ModelAttribute("orderReq") orderRequest: OrderRequest,
              bindingResult: BindingResult,
              modelMap: ModelMap
    ): String {

        try {
            val order = placeOrderService.placeOrder(orderRequest)
            modelMap["order"] = order
            return "order/success"
        } catch (e: ValidationErrorException) {
            e.errors.forEach {
                if(it.hasName()) {
                    bindingResult.rejectValue(it.name, it.code)
                } else {
                    bindingResult.reject(it.code)
                }
            }
            return "order/confirm"
        }
    }
}