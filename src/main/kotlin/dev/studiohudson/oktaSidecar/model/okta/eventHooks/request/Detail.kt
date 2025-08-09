package dev.studiohudson.oktaSidecar.model.okta.eventHooks.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Detail (

    @SerialName("empty"        ) var empty        : String?                = null,
)