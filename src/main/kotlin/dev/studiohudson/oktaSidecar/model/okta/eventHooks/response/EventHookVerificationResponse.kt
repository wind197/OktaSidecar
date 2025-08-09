package dev.studiohudson.oktaSidecar.model.okta.eventHooks.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventHookVerificationResponse(
    @SerialName("verification"        ) var verification        : String?      = null
)