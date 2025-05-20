package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.functions.AsyncEvents
import dev.studiohudson.oktaSidecar.model.okta.hooks.EventHookRequest
import jakarta.annotation.security.RolesAllowed
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event-hooks")
class EventHooks (
    private val asyncEvents: AsyncEvents
){
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/user-created")
    @RolesAllowed("userCreated")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun postCreateUser(@RequestBody event: EventHookRequest) {
        logger.info("Entering user created controller: $event")
        val target = event.target[0].alternateId ?: ""
        asyncEvents.userCreated(target)
        logger.info("Exiting user created controller")
    }
}