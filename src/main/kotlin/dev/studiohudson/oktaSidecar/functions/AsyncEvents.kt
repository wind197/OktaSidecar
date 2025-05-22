package dev.studiohudson.oktaSidecar.functions

import com.okta.sdk.resource.api.GroupApi
import com.okta.sdk.resource.client.ApiClient
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AsyncEvents(
    private val oktaService: ApiClient
) {
    val logger: org.slf4j.Logger = LoggerFactory.getLogger(this::class.java)

    @Async("async-light")
    fun groupCreated(id: String) {
        logger.info("Starting group created service")
        Thread.sleep(10000)
        val groupApi = GroupApi(oktaService)
        val group = groupApi.getGroup(id)
        logger.info("Exiting group created service: $group")
    }
}