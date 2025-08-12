package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorCause(
    @SerialName("errorSummary" ) var errorSummary   : String,
    @SerialName("reason"       ) var reason         : String,
    @SerialName("locationType" ) var locationType   : String,
    @SerialName("location"     ) var location       : String,
    @SerialName("domain"       ) var domain         : String
)
