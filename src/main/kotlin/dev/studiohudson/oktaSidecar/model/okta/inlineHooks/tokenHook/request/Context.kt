package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Context(
    @SerialName("request"      ) var request        : ContextRequest?       = ContextRequest(),
    @SerialName("protocol"     ) var protocol       : Protocol?             = Protocol(),
    @SerialName("session"      ) var session        : Session?              = Session(),
    @SerialName("user"         ) var user           : User?                 = User(),
    @SerialName("policy"       ) var policy         : Policy?               = Policy(),
)
