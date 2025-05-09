package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Outcome (

  @SerialName("result" ) var result : String? = null,
  @SerialName("reason" ) var reason : String? = null

)