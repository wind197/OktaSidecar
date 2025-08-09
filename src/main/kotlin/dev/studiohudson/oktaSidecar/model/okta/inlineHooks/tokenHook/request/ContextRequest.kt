package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContextRequest(
    @SerialName("id"          ) var id           : String?               = null,
    @SerialName("method"      ) var method       : String?               = null,
    @SerialName("url"         ) var url          : URL?                  = null,
    @SerialName("ipAddress"   ) var ipAddress    : String?               = null,
)
