package com.example.dddkotprac.member.infra

import com.example.dddkotprac.member.domain.PasswordChangedEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener


@Component
class PasswordChangedEventHandler {

    @Async
    @TransactionalEventListener(classes = [PasswordChangedEvent::class])
    fun handlePasswordChangedEvent(passwordChangedEvent: PasswordChangedEvent) {
        //
    }
}
