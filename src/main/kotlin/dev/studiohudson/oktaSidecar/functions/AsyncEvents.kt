package dev.studiohudson.oktaSidecar.functions

import com.okta.sdk.resource.api.UserApi
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
    fun userCreated(target: String) {
        logger.info("Starting user created service")
        Thread.sleep(10000)
        val userApi = UserApi(oktaService)
        val users = userApi.listUsers("", target, null, 200, null, null, null, null)
        logger.info("Exiting user created service: $users")
    }
}