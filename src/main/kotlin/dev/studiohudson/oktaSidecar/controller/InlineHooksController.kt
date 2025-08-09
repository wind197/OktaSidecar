package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request.TokenHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response.TokenHookResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/inline-hooks")
class InlineHooksController {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("token")
    fun tokenHook(
        @RequestBody tokenHookRequest: TokenHookRequest
    ) : TokenHookResponse {
        logger.info("Request: $tokenHookRequest")

        logger.info("Identity Claims")
        tokenHookRequest.data?.identity?.claims?.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        logger.info("Access Claims")
        tokenHookRequest.data?.access?.claims?.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        val response = TokenHookResponse(
            command = listOf(
                TokenHookResponse.Command(
                    type = "com.okta.identity.patch",
                    value = listOf(TokenHookResponse.Command.Value(
                        op = "add",
                        path = "/claims/extPatientId",
                        value = "1234"
                    ))
                )
            )
        )
        logger.info("Response: $response")
        return response
    }
}