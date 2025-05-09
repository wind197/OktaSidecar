package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GeographicalContext (

  @SerialName("city"        ) var city        : String?      = null,
  @SerialName("state"       ) var state       : String?      = null,
  @SerialName("country"     ) var country     : String?      = null,
  @SerialName("postalCode"  ) var postalCode  : String?      = null,
  @SerialName("geolocation" ) var geolocation : Geolocation? = Geolocation()

)