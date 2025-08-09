package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    @SerialName("id"                        ) var id                        : String? = null,
    @SerialName("userId"                    ) var userId                    : String? = null,
    @SerialName("login"                     ) var login                     : String? = null,
    @SerialName("createdAt"                 ) var createdAt                 : String? = null,
    @SerialName("expiresAt"                 ) var expiresAt                 : String? = null,
    @SerialName("status"                    ) var status                    : String? = null,
    @SerialName("lastPasswordVerification"  ) var lastPasswordVerification  : String? = null,
    @SerialName("amr"                       ) var amr                       : ArrayList<String> = arrayListOf(),
    @SerialName("idp"                       ) var idp                       : IDP? = IDP(),
    @SerialName("mfaActive"                 ) var mfaActive                 : Boolean? = null,
)
