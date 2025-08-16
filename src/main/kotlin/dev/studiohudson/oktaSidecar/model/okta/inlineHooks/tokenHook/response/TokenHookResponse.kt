package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenHookResponse(
    @SerialName("commands") var commands : List<TokenCommand> = listOf()
)

@Serializable
data class TokenCommand(
    @SerialName("type"  ) var type  : String,
    @SerialName("value" ) var value : List<TokenValue> = listOf(),
)

@Serializable
data class TokenValue(
    @SerialName("op"    ) var op    : String,
    @SerialName("path"  ) var path  : String,
    @SerialName("value" ) var value : String,
)
