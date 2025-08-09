package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("groups"    ) var groups    : HREF?   = null,
    @SerialName("factors"   ) var factors   : HREF?   = null,
) {
    @Serializable
    data class HREF(
        @SerialName("href"  ) var href  : String?   = null,
    )
}
