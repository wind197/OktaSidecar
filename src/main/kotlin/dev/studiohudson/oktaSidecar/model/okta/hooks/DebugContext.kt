package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DebugContext (

  @SerialName("debugData" ) var debugData : DebugData? = DebugData()

)