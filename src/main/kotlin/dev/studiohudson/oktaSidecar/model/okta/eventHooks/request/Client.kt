package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Client (

    @SerialName("userAgent"           ) var userAgent           : UserAgent?           = UserAgent(),
    @SerialName("zone"                ) var zone                : String?              = null,
    @SerialName("device"              ) var device              : String?              = null,
    @SerialName("id"                  ) var id                  : String?              = null,
    @SerialName("ipAddress"           ) var ipAddress           : String?              = null,
    @SerialName("geographicalContext" ) var geographicalContext : GeographicalContext? = GeographicalContext(),
    @SerialName("ipChain"             ) var ipChain             : List<IpChain>?       = listOf(IpChain())

)