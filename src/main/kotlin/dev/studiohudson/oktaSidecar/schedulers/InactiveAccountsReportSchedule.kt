package dev.studiohudson.oktaSidecar.schedulers

import dev.studiohudson.oktaSidecar.jobs.InactiveAccountsReport
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.Trigger
import org.quartz.TriggerBuilder
import org.quartz.SimpleScheduleBuilder.simpleSchedule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InactiveAccountsReportSchedule {

    @Bean
    fun jobDetail(): JobDetail {
        return JobBuilder.newJob().ofType(InactiveAccountsReport::class.java)
            .storeDurably()
            .usingJobData("Hostname", "localhost")
            .withIdentity("TestRun")
            .withDescription("Inactive Accounts Report")
            .build()
    }

    @Bean
    fun trigger(jobDetail: JobDetail): Trigger {
        return TriggerBuilder.newTrigger().forJob(jobDetail)
            .withIdentity("TestRun")
            .withDescription("Run every so often")
            .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(5))
            .build()
    }
}