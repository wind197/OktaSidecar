package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response

import dev.studiohudson.oktaSidecar.serializers.SamlClaimValueSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SamlHookResponse(
    @SerialName("commands") var commands : List<SamlCommand>
)

@Serializable
data class SamlCommand(
    @SerialName("type"  ) var type  : String,
    @SerialName("value" ) var value : List<SamlValue>
)

@Serializable
data class SamlValue(
    @SerialName("op"    ) var op    : String,
    @SerialName("path"  ) var path  : String,
    @Serializable(with = SamlClaimValueSerializer::class)
    @SerialName("value" ) var value : Any,
)

@Serializable
sealed interface SamlClaim {

    @Serializable
    data class AuthnContextValue(
        @SerialName("authnContextClassRef" ) var authnContextClassRef : String
    ) : SamlClaim


    @Serializable
    data class SamlClaimValue(
        @SerialName("attributes"        ) var attributes        : SamlAttributes,
        @SerialName("attributeValues"   ) var attributeValues   : List<SamlAttributeValues>
    )  : SamlClaim
}

@Serializable
data class SamlAttributes(
    @SerialName("NameFormat") var nameFormat : String
)

@Serializable
data class SamlAttributeValues(
    @SerialName("attributes") var attributes : Attributes,
    @SerialName("value"     ) var value      : String
) {
    @Serializable
    data class Attributes(
        @SerialName("xsi:type") var type : String
    )
}
