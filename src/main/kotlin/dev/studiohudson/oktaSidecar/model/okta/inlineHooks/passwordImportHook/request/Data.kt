package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.passwordImportHook.request

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.passwordImportHook.CREDENTIAL
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"           ) var context           : Context,
    @SerialName("action"            ) var action            : Action
)

@Serializable
data class Context(
    @SerialName("request"       ) var request       : Request,
    @SerialName("credential"    ) var credential    : Credential
)

@Serializable
data class Credential(
    @SerialName("username"  ) var username  : String,
    @SerialName("password"  ) var password  : String
)

@Serializable
data class Action(
    @SerialName("credential" ) var credential : CREDENTIAL
)
