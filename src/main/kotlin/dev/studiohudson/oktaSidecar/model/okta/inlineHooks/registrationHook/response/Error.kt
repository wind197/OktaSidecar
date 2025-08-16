package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Error(
    @SerialName("errorSummary") var errorSummary : String,
    @SerialName("errorCauses" ) var errorCauses  : List<ErrorCause>
)
