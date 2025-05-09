package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Actor (

  @SerialName("id"          ) var id          : String? = null,
  @SerialName("type"        ) var type        : String? = null,
  @SerialName("alternateId" ) var alternateId : String? = null,
  @SerialName("displayName" ) var displayName : String? = null,
  @SerialName("detailEntry" ) var detailEntry : String? = null

)