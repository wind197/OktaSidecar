package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.HashMap

@Serializable
data class User(
    @SerialName("id"                ) var id                : String?                   = null,
    @SerialName("passwordChanged"   ) var passwordChanged   : String?                   = null,
    @SerialName("profile"           ) var profile           : Map<String, String>       = HashMap(),
    @SerialName("_links"            ) var links             : Links?                    = null,
    )
