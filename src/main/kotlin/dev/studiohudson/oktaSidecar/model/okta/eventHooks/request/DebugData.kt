package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class DebugData (

  @SerialName("requestId"          ) var requestId       : String? = null,
  @SerialName("dtHash"             ) var dtHash          : String? = null,
  @SerialName("requestUri"         ) var requestUri      : String? = null,
  @SerialName("targetEventHookIds" ) var targetEventHookIds : String? = null,
  @SerialName("url"                ) var url             : String? = null

)