package dev.studiohudson.oktaSidecar.model.okta.hooks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class EventData (

    @SerialName("actor"                 ) var actor                 : Actor?                 = Actor(),
    @SerialName("client"                ) var client                : Client?                = Client(),
    @SerialName("authenticationContext" ) var authenticationContext : AuthenticationContext? = AuthenticationContext(),
    @SerialName("displayMessage"        ) var displayMessage        : String?                = null,
    @SerialName("eventType"             ) var eventType             : String?                = null,
    @SerialName("outcome"               ) var outcome               : Outcome?               = Outcome(),
    @SerialName("published"             ) var published             : String?                = null,
    @SerialName("securityContext"       ) var securityContext       : SecurityContext?       = SecurityContext(),
    @SerialName("severity"              ) var severity              : String?                = null,
    @SerialName("debugContext"          ) var debugContext          : DebugContext?          = DebugContext(),
    @SerialName("legacyEventType"       ) var legacyEventType       : String?                = null,
    @SerialName("transaction"           ) var transaction           : Transaction?           = Transaction(),
    @SerialName("uuid"                  ) var uuid                  : String?                = null,
    @SerialName("version"               ) var version               : String?                = null,
    @SerialName("request"               ) var request               : Request?               = Request(),
    @SerialName("target"                ) var target                : ArrayList<Target>      = arrayListOf()

)