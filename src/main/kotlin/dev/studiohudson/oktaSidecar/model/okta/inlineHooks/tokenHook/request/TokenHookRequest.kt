package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenHookRequest(
    @SerialName("eventType"          ) var eventType            : String?                 = null,
    @SerialName("eventTypeVersion"   ) var eventTypeVersion     : String?                 = null,
    @SerialName("cloudEventVersion"  ) var cloudEventVersion    : String?                 = null,
    @SerialName("source"             ) var source               : String?                 = null,
    @SerialName("eventId"            ) var eventId              : String?                 = null,
    @SerialName("data"               ) var data                 : Data?                   = Data(),
    @SerialName("eventTime"          ) var eventTime            : String?                 = null,
    @SerialName("contentType"        ) var contentType          : String?                 = null,
)
