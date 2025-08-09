package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Client(
    @SerialName("id"     ) var id      : String? = null,
    @SerialName("name"   ) var name    : String? = null,
    @SerialName("type"   ) var type    : String? = null,
)
