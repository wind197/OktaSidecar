package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.functions.UserCreatedHook
import dev.studiohudson.oktaSidecar.model.okta.hooks.EventHookRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("eventHooks")
class EventHooks (
    private val userCreatedHook: UserCreatedHook
){

    @PostMapping("userCreate")
    fun postCreateUser(@RequestBody event: EventHookRequest): String {
        val target = event.target[0].alternateId ?: ""
        return userCreatedHook.execute(target)
    }
}