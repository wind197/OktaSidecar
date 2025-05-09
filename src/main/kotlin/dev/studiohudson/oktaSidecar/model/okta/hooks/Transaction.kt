package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Transaction (

  @SerialName("type"   ) var type   : String? = null,
  @SerialName("id"     ) var id     : String? = null,
  @SerialName("detail" ) var detail : Detail? = Detail()

)