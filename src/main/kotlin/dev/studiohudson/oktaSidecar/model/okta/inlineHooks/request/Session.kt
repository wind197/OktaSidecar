package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    @SerialName("id"                        ) var id                        : String,
    @SerialName("userId"                    ) var userId                    : String,
    @SerialName("login"                     ) var login                     : String,
    @SerialName("createdAt"                 ) var createdAt                 : String,
    @SerialName("expiresAt"                 ) var expiresAt                 : String,
    @SerialName("status"                    ) var status                    : String,
    @SerialName("lastPasswordVerification"  ) var lastPasswordVerification  : String,
    @SerialName("amr"                       ) var amr                       : ArrayList<String>,
    @SerialName("idp"                       ) var idp                       : IDP,
    @SerialName("mfaActive"                 ) var mfaActive                 : Boolean
) {
    @Serializable
    data class IDP(
        @SerialName("id"        ) var id        : String,
        @SerialName("type"      ) var type      : String
    )
}