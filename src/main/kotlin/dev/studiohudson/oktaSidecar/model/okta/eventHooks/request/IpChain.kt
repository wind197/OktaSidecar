package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class IpChain (

    @SerialName("ip"                  ) var ip                  : String?              = null,
    @SerialName("geographicalContext" ) var geographicalContext : GeographicalContext? = GeographicalContext(),
    @SerialName("version"             ) var version             : String?              = null,
    @SerialName("source"              ) var source              : String?              = null

)