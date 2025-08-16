package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Events(
    @SerialName("events") val events : List<EventData>? = listOf(),
)
