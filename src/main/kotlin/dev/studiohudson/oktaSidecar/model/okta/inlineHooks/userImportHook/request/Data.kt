package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.request

import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"   ) var context   : Context,
    @SerialName("action"    ) var action    : Action,
    @SerialName("appUser"   ) var appUser   : User,
    @SerialName("user"      ) var user      : User
) {
    @Serializable
    data class Action(
        @SerialName("result") var result : String
    )

    @Serializable
    data class User(
        @Serializable(with = KotlinxGenericMapSerializer::class)
        @SerialName("profile") var profile : Map<String, Any>
    )
}
