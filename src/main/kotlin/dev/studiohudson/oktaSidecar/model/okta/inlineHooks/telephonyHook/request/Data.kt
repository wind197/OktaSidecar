package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.telephonyHook.request

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.Request
import dev.studiohudson.oktaSidecar.serializers.KotlinxGenericMapSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("context"           ) var context        : Context,
    @Serializable(with = KotlinxGenericMapSerializer::class)
    @SerialName("userProfile"       ) var userProfile    : Map<String, Any>,
    @SerialName("messageProfile"    ) var messageProfile : MessageProfile
)

@Serializable
data class Context(
    @SerialName("request"   ) var request   : Request
)

@Serializable
data class MessageProfile(
    @SerialName("msgTemplate"       ) var msgTemplate       : String,
    @SerialName("phoneNumber"       ) var phoneNumber       : Long,
    @SerialName("otpExpires"        ) var otpExpires        : String,
    @SerialName("deliveryChannel"   ) var deliveryChannel   : String,
    @SerialName("otpCode"           ) var otpCode           : Long,
    @SerialName("locale"            ) var locale            : String
)