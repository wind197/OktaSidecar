package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.quartz.JobDetail
import dev.studiohudson.oktaSidecar.model.quartz.JobRequest
import dev.studiohudson.oktaSidecar.model.quartz.ScheduleDetail
import dev.studiohudson.oktaSidecar.model.quartz.ScheduleRequest
import org.quartz.*
import org.quartz.impl.matchers.GroupMatcher
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/quartz/")
class QuartzController(
    private val scheduler: Scheduler
) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/jobs")
    fun createJob( @RequestBody jobRequest: JobRequest): String {
        logger.info("Got a request to create a job")
        logger.info("Job details : $jobRequest")

        // Setting overwrite flag to true by default
        scheduler.addJob(
            JobBuilder.newJob().ofType(jobRequest.jobClass.jobClass)
                .storeDurably()
                .withIdentity(jobRequest.name, jobRequest.group)
                .withDescription(jobRequest.description)
                .build(),
            true)

        logger.info("Created a job")
        return "OK"
    }

    @GetMapping("/jobs")
    fun listJobs(): List<JobDetail> {
        logger.info("Entering List Jobs")
        val jobs: ArrayList<JobDetail> = arrayListOf()

        for (jobGroupName in scheduler.jobGroupNames) {
            logger.info("Job Group: $jobGroupName")
            for (jobKey in scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName))) {
                logger.info("Job Name: ${jobKey.name}")
                jobs.add(JobDetail.toJobDetail(scheduler.getJobDetail(jobKey)))
            }
        }

        logger.info("Exiting List Jobs")
        return jobs
    }

    @DeleteMapping("/jobs/{group}/{name}")
    fun deleteJob(
        @PathVariable group: String,
        @PathVariable name: String
    ): Boolean {
        logger.info("Got a request to delete a job")
        logger.info("Job details: $group.$name")

        val result = scheduler.deleteJob(JobKey.jobKey(name, group))

        logger.info("Deleted a job")
        return result
    }

    @PostMapping("/schedule")
    fun createSchedule( @RequestBody scheduleRequest: ScheduleRequest): String {
        logger.info("Got a request to create a schedule")

        scheduler.scheduleJob(
            TriggerBuilder.newTrigger().forJob(scheduler.getJobDetail(JobKey(scheduleRequest.jobDetail.name, scheduleRequest.jobDetail.group)))
                .withIdentity(scheduleRequest.name, scheduleRequest.group)
                .withDescription(scheduleRequest.description)
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleRequest.schedule))
                .startNow()
                .build()
        )

        logger.info("Created a schedule")
        return "OK"
    }

    @GetMapping("/schedule")
    fun listSchedules(): List<ScheduleDetail> {
        logger.info("Got a request to list schedules")
        val schedules: ArrayList<ScheduleDetail> = arrayListOf()

        for (triggerGroup in scheduler.triggerGroupNames) {
            logger.info("Trigger Group: $triggerGroup")
            for (triggerKey in scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(triggerGroup))) {
                logger.info("Trigger name: ${triggerKey.name}")
                val triggerDetail = scheduler.getTrigger(triggerKey)
                schedules.add(ScheduleDetail(
                    name = triggerKey.name,
                    group = triggerKey.group,
                    description = triggerDetail.description,
                    schedule = (triggerDetail as CronTrigger).cronExpression,
                    lastRun = triggerDetail.previousFireTime.toString(),
                    nextRun = triggerDetail.nextFireTime.toString(),
                    jobDetail = JobDetail.toJobDetail(scheduler.getJobDetail(triggerDetail.jobKey))
                ))
            }
        }

        logger.info("Listed schedules!")
        return schedules
    }

    @DeleteMapping("/schedule/{group}/{name}")
    fun deleteSchedule(
        @PathVariable group: String,
        @PathVariable name: String
    ): Boolean {
        logger.info("Got a request to delete a schedule")

        val result = scheduler.unscheduleJob(TriggerKey(name, group))

        logger.info("Deleted a schedule")
        return result
    }

}