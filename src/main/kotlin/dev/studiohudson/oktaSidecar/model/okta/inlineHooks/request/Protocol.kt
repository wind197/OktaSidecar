package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class Protocol {
    abstract var type: String?

    @Serializable
    @SerialName("OAUTH2.0")
    data class oauthProtocol(
        @SerialName("type") override var type: String? = null,
        @SerialName("request") var request: Request? = Request(),
        @SerialName("issuer") var issuer: Issuer? = Issuer(),
        @SerialName("client") var client: Client? = Client(),
    ) : Protocol() {
        @Serializable
        data class Issuer(
            @SerialName("uri"   ) var uri    : String? = null,
        )

        @Serializable
        data class Client(
            @SerialName("id"     ) var id      : String? = null,
            @SerialName("name"   ) var name    : String? = null,
            @SerialName("type"   ) var type    : String? = null,
        )

        @Serializable
        data class Request(
            @SerialName("scope"            ) var scope           : String?               = null,
            @SerialName("state"            ) var state           : String?               = null,
            @SerialName("redirect_uri"     ) var redirectUri     : String?               = null,
            @SerialName("response_mode"    ) var responseMode    : String?               = null,
            @SerialName("response_type"    ) var responseType    : String?               = null,
            @SerialName("client_id"        ) var clientId        : String?               = null,
        )
    }

    @Serializable
    @SerialName("SAML2.0")
    data class samlProtocol(
        @SerialName("type") override var type: String? = null,
        @SerialName("issuer") var issuer: Issuer? = Issuer(),
    ) : Protocol() {
        @Serializable
        data class Issuer(
            @SerialName("id") var id: String? = null,
            @SerialName("name") var name: String? = null,
            @SerialName("uri") var uri: String? = null,
        )
    }

}