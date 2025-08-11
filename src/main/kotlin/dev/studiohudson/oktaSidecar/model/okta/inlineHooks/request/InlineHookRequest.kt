package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request.Data as SamlData
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request.Data as TokenData
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.request.Data as UserImportData

@Serializable
sealed interface InlineHookRequest {
    var eventType : String
    var eventTypeVersion : String
    var cloudEventVersion : String
    var source : String
    var eventId : String
    var eventTime : String
    var contentType : String

    @Serializable
    @SerialName("com.okta.oauth2.tokens.transform")
    data class TokenHookRequest(
        @SerialName("eventType"          ) override var eventType            : String,
        @SerialName("eventTypeVersion"   ) override var eventTypeVersion     : String,
        @SerialName("cloudEventVersion"  ) override var cloudEventVersion    : String,
        @SerialName("source"             ) override var source               : String,
        @SerialName("eventId"            ) override var eventId              : String,
        @SerialName("eventTime"          ) override var eventTime            : String,
        @SerialName("contentType"        ) override var contentType          : String,
        @SerialName("data"               )          var data                 : TokenData
        ) : InlineHookRequest

    @Serializable
    @SerialName("com.okta.saml.tokens.transform")
    data class SamlHookRequest(
        @SerialName("eventType"          ) override var eventType            : String,
        @SerialName("eventTypeVersion"   ) override var eventTypeVersion     : String,
        @SerialName("cloudEventVersion"  ) override var cloudEventVersion    : String,
        @SerialName("source"             ) override var source               : String,
        @SerialName("eventId"            ) override var eventId              : String,
        @SerialName("eventTime"          ) override var eventTime            : String,
        @SerialName("contentType"        ) override var contentType          : String,
        @SerialName("data"               )          var data                 : SamlData
        ) : InlineHookRequest

    @Serializable
    @SerialName("com.okta.import.transform")
    data class UserImportHookRequest(
        @SerialName("eventType"          ) override var eventType            : String,
        @SerialName("eventTypeVersion"   ) override var eventTypeVersion     : String,
        @SerialName("cloudEventVersion"  ) override var cloudEventVersion    : String,
        @SerialName("source"             ) override var source               : String,
        @SerialName("eventId"            ) override var eventId              : String,
        @SerialName("eventTime"          ) override var eventTime            : String,
        @SerialName("contentType"        ) override var contentType          : String,
        @SerialName("data"               )          var data                 : UserImportData
        ) : InlineHookRequest

    @Serializable
    @SerialName("com.okta.user.pre-registration")
    data class RegistrationHookRequest(
        @SerialName("eventType"          ) override var eventType            : String,
        @SerialName("eventTypeVersion"   ) override var eventTypeVersion     : String,
        @SerialName("cloudEventVersion"  ) override var cloudEventVersion    : String,
        @SerialName("source"             ) override var source               : String,
        @SerialName("eventId"            ) override var eventId              : String,
        @SerialName("eventTime"          ) override var eventTime            : String,
        @SerialName("contentType"        ) override var contentType          : String,
        @SerialName("requestType"        ) var requestType                   : String,
        @SerialName("data"               ) var data                          : String
        ) : InlineHookRequest


}