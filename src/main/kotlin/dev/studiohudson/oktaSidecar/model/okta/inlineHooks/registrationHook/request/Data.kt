package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.request

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.Request
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.User
import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"       ) var context       : Context,
    @SerialName("action"        ) var action        : String,
    @Serializable(with = KotlinxGenericMapSerializer::class)
    @SerialName("userProfile"   ) var userProfile   : Map<String, Any>? = null,
    @Serializable(with = KotlinxGenericMapSerializer::class)
    @SerialName("userProfileUpdate"   ) var userProfileUpdate   : Map<String, Any>? = null,
) {
    @Serializable
    data class Context(
        @SerialName("request") var request : Request,
        @SerialName("user"   ) var user    : User?      = null
    )
}
