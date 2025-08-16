package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DebugContext (

  @SerialName("debugData" ) var debugData : DebugData? = DebugData()

)