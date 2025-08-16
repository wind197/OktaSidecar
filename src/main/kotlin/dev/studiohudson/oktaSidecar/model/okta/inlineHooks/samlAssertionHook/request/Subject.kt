package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subject(
    @SerialName("nameId"        ) var nameId        : String,
    @SerialName("nameFormat"    ) var nameFormat    : String,
    @SerialName("confirmation"  ) var confirmation  : Confirmation,
) {
    @Serializable
    data class Confirmation(
        @SerialName("method"    ) var method    : String,
        @SerialName("data"      ) var data      : Data
    ) {
        @Serializable
        data class Data(
            @SerialName("recipient" ) var recipient : String
        )
    }
}
