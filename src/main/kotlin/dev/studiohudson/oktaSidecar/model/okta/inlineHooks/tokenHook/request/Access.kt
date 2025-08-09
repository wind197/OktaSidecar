package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Access(
    @Serializable(with = KotlinxGenericMapSerializer::class)
    @SerialName("claims"    ) var claims    : Map<String, Any>   = HashMap(),
    @SerialName("token"     ) var token     : Token                 = Token(),
    @SerialName("scopes"    ) var scopes    : Map<String,Scope>     = HashMap(),
) {
    @Serializable
    data class Token(
        @SerialName("lifetime") var lifetime : Lifetime = Lifetime()
    ) {
        @Serializable
        data class Lifetime(
            @SerialName("expiration") var expiration : Int? = null
        )
    }
}
