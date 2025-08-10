package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"         ) var context           : Context,
    @SerialName("assertion"       ) var assertion         : Assertion,
)
