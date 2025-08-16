package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Request(
    @SerialName("id"          ) var id           : String,
    @SerialName("method"      ) var method       : String,
    @SerialName("url"         ) var url          : URL,
    @SerialName("ipAddress"   ) var ipAddress    : String
) {
    @Serializable
    data class URL(
        @SerialName("value"        ) var value        : String
    )
}