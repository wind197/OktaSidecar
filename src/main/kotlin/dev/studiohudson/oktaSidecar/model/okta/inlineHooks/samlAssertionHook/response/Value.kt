package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response

import dev.studiohudson.oktaSidecar.serializers.SamlClaimValueSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Value(
    @SerialName("op"    ) var op    : String,
    @SerialName("path"  ) var path  : String,
    @Serializable(with = SamlClaimValueSerializer::class)
    @SerialName("value" ) var value : Any,
    ) {

    @Serializable
    sealed interface ClaimValue {

//        @Serializable


        @Serializable
        data class AuthnContextValue(
            @SerialName("authnContextClassRef" ) var authnContextClassRef : String
        ) : ClaimValue


        @Serializable
        data class SamlClaimValue(
            @SerialName("attributes"        ) var attributes        : Attributes,
            @SerialName("attributeValues"   ) var attributeValues   : List<AttributeValues>
        )  : ClaimValue {
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
    }
}
