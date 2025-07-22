package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.functions.AsyncEvents
import dev.studiohudson.oktaSidecar.model.okta.hooks.EventHookRequest
import dev.studiohudson.oktaSidecar.model.okta.hooks.EventHookVerificationResponse
import jakarta.annotation.security.RolesAllowed
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/event-hooks")
class EventHooksController (
    private val asyncEvents: AsyncEvents
){
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/group-created")
    @RolesAllowed("groupCreated")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun postGroupCreated(
        @RequestBody eventHookRequest: EventHookRequest
    ) {
        logger.info("Entering group created controller: ${eventHookRequest.eventId}")
        for (event in eventHookRequest.data?.events!!) {
            asyncEvents.groupCreated(event.target[0].id ?: "")
        }
        logger.info("Exiting group created controller")
    }

    @GetMapping("/group-created")
    @RolesAllowed("groupCreated")
    fun getGroupCreated(
        @RequestHeader("x-okta-verification-challenge") verificationHeader: String
    ): EventHookVerificationResponse {
        return EventHookVerificationResponse(verificationHeader)
    }
}