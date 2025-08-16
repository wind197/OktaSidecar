package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class SecurityContext (

  @SerialName("asNumber" ) var asNumber : Int?     = null,
  @SerialName("asOrg"    ) var asOrg    : String?  = null,
  @SerialName("isp"      ) var isp      : String?  = null,
  @SerialName("domain"   ) var domain   : String?  = null,
  @SerialName("isProxy"  ) var isProxy  : Boolean? = null

)