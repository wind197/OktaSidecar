package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class UserAgent (

  @SerialName("rawUserAgent" ) var rawUserAgent : String? = null,
  @SerialName("os"           ) var os           : String? = null,
  @SerialName("browser"      ) var browser      : String? = null

)