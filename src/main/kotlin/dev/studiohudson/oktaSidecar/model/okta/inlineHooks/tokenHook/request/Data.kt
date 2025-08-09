package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"         ) var context           : Context?        = null,
    @SerialName("identity"        ) var identity          : Identity?       = null,
    @SerialName("access"          ) var access            : Access?         = null,
    @SerialName("refresh_token"   ) var refreshToken      : RefreshToken?   = null,
) {
    @Serializable
    data class RefreshToken(
        @SerialName("jti") var jti : String? = null
    )
}
