package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response

import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationHookResponse(
    @SerialName("commands") var commands : List<Command>,
    @SerialName("error"   ) var error    : Error?           = null
) {
    @Serializable
    sealed interface Command {

        @Serializable
        @SerialName("com.okta.user.progressive.profile.update")
        data class ProgressiveProfileCommand(
            @Serializable(with = KotlinxGenericMapSerializer::class)
            @SerialName("value")          var value : Map<String, Any>
        ) : Command

        @Serializable
        @SerialName("com.okta.user.profile.update")
        data class ProfileCommand(
            @Serializable(with = KotlinxGenericMapSerializer::class)
            @SerialName("value")          var value : Map<String, Any>
        ) : Command

        @Serializable
        @SerialName("com.action.update")
        data class RegistrationCommand(
            @SerialName("value")          var value : Value
        ) : Command {
            @Serializable
            data class Value(
                @SerialName("registration") var registration : REGISTRATION
            ) {
                enum class REGISTRATION {
                    ALLOW, DENY
                }
            }
        }


    }
}
