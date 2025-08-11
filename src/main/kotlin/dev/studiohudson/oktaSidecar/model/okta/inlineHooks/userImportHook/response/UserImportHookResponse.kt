package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.response

import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserImportHookResponse(
    @SerialName("commands") var commands: List<Command>
) {
    @Serializable
    data class Command(
        @SerialName("type") var type : String,
        @Serializable(with = KotlinxGenericMapSerializer::class)
        @SerialName("value") var value : Map<String,Any>,
    )
}
