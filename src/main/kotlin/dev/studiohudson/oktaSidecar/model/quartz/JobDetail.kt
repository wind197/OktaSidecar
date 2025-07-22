package dev.studiohudson.oktaSidecar.model.quartz

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobDetail(
    @SerialName("name"          ) var name          : String? = null,
    @SerialName("group"         ) var group         : String? = null,
    @SerialName("description"   ) var description   : String? = null,
    @SerialName("class"         ) var jobClass      : QuartzJobs? = null
)
{
    companion object {
        fun toJobDetail(job: org.quartz.JobDetail): JobDetail {
            return JobDetail(
                name = job.key.name,
                group = job.key.group,
                description = job.description,
                jobClass = QuartzJobs from job.jobClass
            )
        }
    }
}
