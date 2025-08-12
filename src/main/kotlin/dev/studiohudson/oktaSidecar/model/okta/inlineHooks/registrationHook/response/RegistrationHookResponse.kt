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
//        var type: String

        @Serializable
        @SerialName("com.okta.user.progressive.profile.update")
        data class ProgressiveProfileCommand(
//            @SerialName("type" ) override var type : String,
            @Serializable(with = KotlinxGenericMapSerializer::class)
            @SerialName("value")          var value : Map<String, Any>
        ) : Command

        @Serializable
        @SerialName("com.okta.user.profile.update")
        data class ProfileCommand(
//            @SerialName("type" ) override var type : String,
            @Serializable(with = KotlinxGenericMapSerializer::class)
            @SerialName("value")          var value : Map<String, Any>
        ) : Command

        @Serializable
        @SerialName("com.action.update")
        data class RegistrationCommand(
//            @SerialName("type" ) override var type  : String,
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
