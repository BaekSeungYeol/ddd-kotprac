package com.example.dddkotprac.common.event

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class EventStoreHandler(
//    private val eventStore: EventStore
) {

    @Async
    @EventListener(Event::class)
    fun handle(event: Event) {
//       eventStore.save(event)
    }

}