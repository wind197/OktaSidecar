package dev.studiohudson.oktaSidecar.model.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoMetadata(
    @SerialName("id"          ) var id          : Int? = null,
    @SerialName("fileName"    ) var fileName    : String? = null,
    @SerialName("contentType" ) var contentType : String? = null
)
