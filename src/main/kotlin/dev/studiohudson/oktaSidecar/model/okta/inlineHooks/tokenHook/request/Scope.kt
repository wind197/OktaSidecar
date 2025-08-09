package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Scope(
    @SerialName("id")       var id      : String? = null,
    @SerialName("action")   var action  : String? = null,
)
