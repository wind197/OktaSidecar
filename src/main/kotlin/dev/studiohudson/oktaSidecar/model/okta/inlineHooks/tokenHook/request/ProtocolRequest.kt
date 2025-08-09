package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProtocolRequest(
    @SerialName("scope"            ) var scope           : String?               = null,
    @SerialName("state"            ) var state           : String?               = null,
    @SerialName("redirect_uri"     ) var redirectUri     : String?               = null,
    @SerialName("response_mode"    ) var responseMode    : String?               = null,
    @SerialName("response_type"    ) var responseType    : String?               = null,
    @SerialName("client_id"        ) var clientId        : String?               = null,
)
