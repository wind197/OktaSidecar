package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.Protocol
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.Request
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.Session
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Context(
    @SerialName("request"      ) var request        : Request,
    @SerialName("protocol"     ) var protocol       : Protocol,
    @SerialName("session"      ) var session        : Session,
    @SerialName("user"         ) var user           : User
)
