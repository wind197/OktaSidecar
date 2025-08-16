package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.passwordImportHook.response

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.passwordImportHook.CREDENTIAL
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PasswordImportHookResponse(
    @SerialName("commands") var commands : List<PasswordCommand>
)

@Serializable
data class PasswordCommand(
    @SerialName("type"  ) var type  : String,
    @SerialName("value" ) var value : PasswordValue
)

@Serializable
data class PasswordValue(
    @SerialName("credential" ) var credential : CREDENTIAL
)