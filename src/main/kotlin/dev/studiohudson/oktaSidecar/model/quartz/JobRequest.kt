package dev.studiohudson.oktaSidecar.model.quartz

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobRequest(
    @SerialName("name"          ) var name          : String,
    @SerialName("group"         ) var group         : String,
    @SerialName("description"   ) var description   : String,
    @SerialName("class"         ) var jobClass      : QuartzJobs
)
