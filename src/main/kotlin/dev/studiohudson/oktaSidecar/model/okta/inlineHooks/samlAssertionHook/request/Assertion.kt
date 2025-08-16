package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Assertion(
    @SerialName("subject"           ) var subject           : Subject,
    @SerialName("authentication"    ) var authentication    : Authentication,
    @SerialName("conditions"        ) var conditions        : Conditions,
    @SerialName("claims"            ) var claims            : Map<String, SamlClaim>,
    @SerialName("lifetime"          ) var lifetime          : Lifetime
) {
    @Serializable
    data class Conditions(
        @SerialName("audienceRestriction" ) var audienceRestriction : List<String>
    )

    @Serializable
    data class Lifetime(
        @SerialName("expiration") var expiration : Int
    )
}
