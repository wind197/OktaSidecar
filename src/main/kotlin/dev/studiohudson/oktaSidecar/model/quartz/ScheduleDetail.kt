package dev.studiohudson.oktaSidecar.model.quartz

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleDetail(
    @SerialName("name"          ) var name          : String,
    @SerialName("group"         ) var group         : String,
    @SerialName("description"   ) var description   : String? = null,
    @SerialName("schedule"      ) var schedule      : String,
    @SerialName("lastRun"       ) var lastRun       : String? = null,
    @SerialName("nextRun"       ) var nextRun       : String? = null,
    @SerialName("jobDetail"     ) var jobDetail     : JobDetail
)
