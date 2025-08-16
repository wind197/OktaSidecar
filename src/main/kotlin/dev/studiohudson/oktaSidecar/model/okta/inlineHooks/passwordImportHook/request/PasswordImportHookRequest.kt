package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.passwordImportHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PasswordImportHookRequest(
    @SerialName("eventType"          ) var eventType            : String,
    @SerialName("eventTypeVersion"   ) var eventTypeVersion     : String,
    @SerialName("cloudEventVersion"  ) var cloudEventVersion    : String,
    @SerialName("source"             ) var source               : String,
    @SerialName("eventId"            ) var eventId              : String,
    @SerialName("eventTime"          ) var eventTime            : String,
    @SerialName("contentType"        ) var contentType          : String,
    @SerialName("data"               ) var data                 : Data
)
