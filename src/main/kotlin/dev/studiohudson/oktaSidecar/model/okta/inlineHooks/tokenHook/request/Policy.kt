package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Policy(
    @SerialName("id"    ) var id    : String,
    @SerialName("rule"  ) var rule  : Rule
) {
    @Serializable
    data class Rule(
        @SerialName("id"    ) var id    : String
    )
}
