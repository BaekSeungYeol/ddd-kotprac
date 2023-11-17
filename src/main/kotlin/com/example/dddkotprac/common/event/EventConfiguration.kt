package com.example.dddkotprac.common.event

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class EventsConfiguration {

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Bean
    fun eventsInitializer(): InitializingBean {
        return InitializingBean { Events.setPublisher(applicationContext) }
    }
}

