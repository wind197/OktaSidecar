package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IDP(
    @SerialName("id"        ) var id        : String? = null,
    @SerialName("type"      ) var type      : String? = null,
    )
