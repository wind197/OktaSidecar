package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    @Serializable(with = KotlinxGenericMapSerializer::class)
    @SerialName("claims"    ) var claims    : Map<String, Any>,
    @SerialName("token"     ) var token     : Token,
) {
    @Serializable
    data class Token(
        @SerialName("lifetime") var lifetime : Lifetime
    ) {
        @Serializable
        data class Lifetime(
            @SerialName("expiration") var expiration : Int
        )
    }
}
