package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenHookResponse(
    @SerialName("commands") var command : List<Command> = listOf()
) {
    @Serializable
    data class Command(
        @SerialName("type"  ) var type  : String,
        @SerialName("value" ) var value : List<Value> = listOf(),
    ) {
        @Serializable
        data class Value(
            @SerialName("op"    ) var op    : String,
            @SerialName("path"  ) var path  : String,
            @SerialName("value" ) var value : String,
        )
    }
}
