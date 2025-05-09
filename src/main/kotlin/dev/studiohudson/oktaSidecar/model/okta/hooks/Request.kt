package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Request (

  @SerialName("ipChain" ) var ipChain : ArrayList<IpChain> = arrayListOf()

)