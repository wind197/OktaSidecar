package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SamlClaim(
    @SerialName("attributes"        ) var attributes        : Attributes,
    @SerialName("attributeValues"   ) var attributeValues   : List<AttributeValues>
) {
    @Serializable
    data class Attributes(
        @SerialName("NameFormat") var nameFormat : String
    )

    @Serializable
    data class AttributeValues(
        @SerialName("attributes") var attributes : Attributes,
        @SerialName("value"     ) var value      : String
    ) {
        @Serializable
        data class Attributes(
            @SerialName("xsi:type") var type : String
        )
    }
}
