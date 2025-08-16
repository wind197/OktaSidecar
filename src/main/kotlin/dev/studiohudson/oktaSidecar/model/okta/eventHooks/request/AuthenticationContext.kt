package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class AuthenticationContext (

  @SerialName("authenticationProvider" ) var authenticationProvider : String? = null,
  @SerialName("credentialProvider"     ) var credentialProvider     : String? = null,
  @SerialName("credentialType"         ) var credentialType         : String? = null,
  @SerialName("issuer"                 ) var issuer                 : String? = null,
  @SerialName("interface"              ) var Xinterface             : String? = null,
  @SerialName("authenticationStep"     ) var authenticationStep     : Int?    = null,
  @SerialName("externalSessionId"      ) var externalSessionId      : String? = null

)