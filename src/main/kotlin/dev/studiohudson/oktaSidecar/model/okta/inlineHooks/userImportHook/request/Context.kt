package dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Context(
    @SerialName("conflicts"     ) var conflicts     : List<String>,
    @SerialName("application"   ) var application   : Application,
    @SerialName("job"           ) var job           : Job,
    @SerialName("matches"       ) var matches       : List<String>,
    @SerialName("policy"        ) var policy        : List<String>
) {
    @Serializable
    data class Application(
        @SerialName("name"  ) var name  : String,
        @SerialName("id"    ) var id    : String,
        @SerialName("label" ) var label : String,
        @SerialName("status") var status: String
    )

    @Serializable
    data class Job(
        @SerialName("id"    ) var id    : String,
        @SerialName("type"  ) var type  : String
    )
}
