package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.InlineHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlHookResponse
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.Value
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
        @RequestBody tokenHookRequest: InlineHookRequest.TokenHookRequest
    ) : TokenHookResponse {
        logger.info("Request: $tokenHookRequest")

        logger.info("Identity Claims")
        tokenHookRequest.data.identity.claims.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        logger.info("Access Claims")
        tokenHookRequest.data.access.claims.forEach { logger.info("Claim ${it.key} : ${it.value}") }

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

    @PostMapping("saml")
    fun samlHook(
        @RequestBody samlHookRequest: InlineHookRequest.SamlHookRequest
    ) : SamlHookResponse {
        logger.info("Request: $samlHookRequest")

        logger.info("SAML Claims")
        samlHookRequest.data.assertion.claims.forEach { logger.info("Claim ${it.key} : ${it.value.attributeValues.map { it.value }}") }

        val response = SamlHookResponse(
            command = listOf(
                SamlHookResponse.Command(
                    type = "com.okta.assertion.patch",
                    value = listOf(
                        Value(
                            op = "add",
                            path = "/claims/extPatientId",
                            value = "1234"
                        ),
                        Value(
                            op = "app",
                            path = "/claims/val",
                            value = Value.ClaimValue.SamlClaimValue(
                                attributes = Value.ClaimValue.SamlClaimValue.Attributes(
                                    nameFormat = "unspecified"
                                ),
                                attributeValues = listOf(
                                    Value.ClaimValue.SamlClaimValue.AttributeValues(
                                        attributes = Value.ClaimValue.SamlClaimValue.AttributeValues.Attributes(
                                            type = "xs:string"
                                        ),
                                        value = "4321"
                                    )
                                )
                            )
                        ),
                        Value(
                            op = "replace",
                            path = "/authentication/authnContext",
                            value = Value.ClaimValue.AuthnContextValue(
                                authnContextClassRef = "replacemantValue"
                            )
                        )
                    )
                )
            )
        )
        logger.info("Response: $response")
        return response
    }
}