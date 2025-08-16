package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"         ) var context           : Context,
    @SerialName("identity"        ) var identity          : Identity,
    @SerialName("access"          ) var access            : Access,
    @SerialName("refresh_token"   ) var refreshToken      : RefreshToken,
) {
    @Serializable
    data class RefreshToken(
        @SerialName("jti") var jti : String
    )
}
