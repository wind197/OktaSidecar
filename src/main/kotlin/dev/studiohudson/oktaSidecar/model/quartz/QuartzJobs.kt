package dev.studiohudson.oktaSidecar.model.quartz

import dev.studiohudson.oktaSidecar.jobs.FailedLoginReport
import dev.studiohudson.oktaSidecar.jobs.InactiveAccountsReport
import org.quartz.Job

enum class QuartzJobs(val jobClass: Class<out Job>) {
    INACTIVEACCOUNTREPORT(InactiveAccountsReport::class.java),
    FAILEDLOGINREPORT(FailedLoginReport::class.java);

//    companion object {
//        infix fun from(jobClass: Class<out Job>): QuartzJobs? = entries.firstOrNull { it.jobClass == jobClass }
//    }
//
    companion object {
        private val map = entries.associateBy { it.jobClass }
        infix fun from(jobClass: Class<out Job>) = map[jobClass]
    }
}