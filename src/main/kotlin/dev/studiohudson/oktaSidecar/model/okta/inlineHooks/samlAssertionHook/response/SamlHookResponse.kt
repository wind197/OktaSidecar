package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SamlHookResponse(
    @SerialName("commands") var command : List<Command>
) {
    @Serializable
    data class Command(
        @SerialName("type"  ) var type  : String,
        @SerialName("value" ) var value : List<Value>
    )
}
