package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventHookRequest(
    @SerialName("eventType"          ) var eventType            : String?                 = null,
    @SerialName("eventTypeVersion"   ) var eventTypeVersion     : String?                 = null,
    @SerialName("cloudEventsVersion" ) var cloudEventsVersion   : String?                 = null,
    @SerialName("source"             ) var source               : String?                 = null,
    @SerialName("eventId"            ) var eventId              : String?                 = null,
    @SerialName("data"               ) var data                 : Events?                 = Events(),
    @SerialName("eventTime"          ) var eventTime            : String?                 = null,
    @SerialName("contentType"        ) var contentType          : String?                 = null,
    )
