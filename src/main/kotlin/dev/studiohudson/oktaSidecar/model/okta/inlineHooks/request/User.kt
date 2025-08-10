package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request

import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id"                ) var id                : String,
    @SerialName("passwordChanged"   ) var passwordChanged   : String,
    @Serializable(with = KotlinxGenericMapSerializer::class)
    @SerialName("profile"           ) var profile           : Map<String, Any>,
    @SerialName("_links"            ) var links             : Links
) {
    @Serializable
    data class Links(
        @SerialName("groups"    ) var groups    : HREF,
        @SerialName("factors"   ) var factors   : HREF
    ) {
        @Serializable
        data class HREF(
            @SerialName("href"  ) var href  : String
        )
    }
}