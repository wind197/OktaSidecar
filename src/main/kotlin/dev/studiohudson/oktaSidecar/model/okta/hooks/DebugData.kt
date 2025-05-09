package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class DebugData (

  @SerialName("requestId"       ) var requestId       : String? = null,
  @SerialName("requestUri"      ) var requestUri      : String? = null,
  @SerialName("threatSuspected" ) var threatSuspected : String? = null,
  @SerialName("url"             ) var url             : String? = null

)