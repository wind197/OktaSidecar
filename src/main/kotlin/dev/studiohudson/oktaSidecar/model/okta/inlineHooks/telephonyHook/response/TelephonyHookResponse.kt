package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.telephonyHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TelephonyHookResponse(
    @SerialName("commands") var commands : List<TelephonyCommand>
)

@Serializable
data class TelephonyCommand(
    @SerialName("type"  ) var type  : String,
    @SerialName("value" ) var value : List<TelephonyValue>
)

@Serializable
data class TelephonyValue(
    @SerialName("status"                ) var status                : String,
    @SerialName("provider"              ) var provider              : String,
    @SerialName("transactionId"         ) var transactionId         : String,
    @SerialName("transactionMetadata"   ) var transactionMetadata   : String
)