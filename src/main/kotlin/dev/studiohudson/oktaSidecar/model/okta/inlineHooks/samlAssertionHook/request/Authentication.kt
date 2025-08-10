package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Authentication(
    @SerialName("sessionIndex"  ) var sessionIndex  : String,
    @SerialName("authnContext"  ) var authnContext  : AuthnContext
) {
    @Serializable
    data class AuthnContext(
        @SerialName("authnContextClassRef" ) var authnContextClassRef : String
    )
}
