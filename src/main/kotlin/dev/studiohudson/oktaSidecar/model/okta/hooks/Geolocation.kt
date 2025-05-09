package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Geolocation (

  @SerialName("lat" ) var lat : Double? = null,
  @SerialName("lon" ) var lon : Double? = null

)