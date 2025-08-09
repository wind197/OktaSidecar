package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Protocol(
    @SerialName("type"     ) var type         : String?               = null,
    @SerialName("request"  ) var request      : ProtocolRequest?      = ProtocolRequest(),
    @SerialName("issuer"   ) var issuer       : Issuer?               = null,
    @SerialName("client"   ) var client       : Client?               = null,
)
