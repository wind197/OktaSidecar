package dev.studiohudson.oktaSidecar.jobs

import org.quartz.Job
import org.quartz.JobExecutionContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class InactiveAccountsReport(): Job {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(context: JobExecutionContext?) {
        logger.info("Inactive Accounts Report")
    }
}