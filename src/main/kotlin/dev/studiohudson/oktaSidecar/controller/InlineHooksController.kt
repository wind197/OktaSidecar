package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.request.RegistrationHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response.RegistrationCommand
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response.RegistrationHookResponse
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response.REGISTRATION
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response.RegistrationValue
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.request.SamlHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlAttributeValues
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlAttributes
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlClaim
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlHookResponse
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlCommand
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlValue
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.request.TokenHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response.TokenCommand
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response.TokenHookResponse
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response.TokenValue
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.request.UserImportHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.response.UserImportCommand
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.userImportHook.response.UserImportHookResponse
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
        tokenHookRequest.data.identity.claims.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        logger.info("Access Claims")
        tokenHookRequest.data.access.claims.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        val response = TokenHookResponse(
            commands = listOf(
                TokenCommand(
                    type = "com.okta.identity.patch",
                    value = listOf(
                        TokenValue(
                            op = "add",
                            path = "/claims/extPatientId",
                            value = "1234"
                        )
                    )
                )
            )
        )
        logger.info("Response: $response")
        return response
    }

    @PostMapping("saml")
    fun samlHook(
        @RequestBody samlHookRequest: SamlHookRequest
    ) : SamlHookResponse {
        logger.info("Request: $samlHookRequest")

        logger.info("SAML Claims")
        samlHookRequest.data.assertion.claims.forEach { logger.info("Claim ${it.key} : ${it.value.attributeValues.map { it.value }}") }

        val response = SamlHookResponse(
            commands = listOf(
                SamlCommand(
                    type = "com.okta.assertion.patch",
                    value = listOf(
                        SamlValue(
                            op = "add",
                            path = "/claims/extPatientId",
                            value = 1234
                        ),
                        SamlValue(
                            op = "add",
                            path = "/claims/extPatientId",
                            value = 1.2
                        ),
                        SamlValue(
                            op = "add",
                            path = "/claims/extPatientId",
                            value = true
                        ),
                        SamlValue(
                            op = "add",
                            path = "/claims/extPatientId",
                            value = "Hello"
                        ),
                        SamlValue(
                            op = "app",
                            path = "/claims/val",
                            value = SamlClaim.SamlClaimValue(
                                attributes = SamlAttributes(
                                    nameFormat = "unspecified"
                                ),
                                attributeValues = listOf(
                                    SamlAttributeValues(
                                        attributes = SamlAttributeValues.Attributes(
                                            type = "xs:integer"
                                        ),
                                        value = "4321"
                                    )
                                )
                            )
                        ),
                        SamlValue(
                            op = "replace",
                            path = "/authentication/authnContext",
                            value = SamlClaim.AuthnContextValue(
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

    @PostMapping("userImport")
    fun userImportHook(
        @RequestBody userImportHookRequest: UserImportHookRequest
    ) : UserImportHookResponse {
        logger.info("Request: $userImportHookRequest")

        logger.info("User Profile")
        userImportHookRequest.data.user.profile.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        logger.info("App User Profile")
        userImportHookRequest.data.appUser.profile.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        val response = UserImportHookResponse(
            commands = listOf(
                UserImportCommand(
                    type = "com.okta.action.update",
                    value = mapOf(
                        Pair("result", "CREATE_USER")
                    )
                )
            )
        )
        logger.info("Response: $response")
        return response
    }

    @PostMapping("registration")
    fun registrationHook(
        @RequestBody registrationHookRequest: RegistrationHookRequest
    ) : RegistrationHookResponse {
        logger.info("Request: $registrationHookRequest")

        if (registrationHookRequest.data.userProfile != null) {
            logger.info("User Profile")
            registrationHookRequest.data.userProfile?.forEach { logger.info("Attribute ${it.key} : ${it.value}") }
        }

        if (registrationHookRequest.data.userProfileUpdate != null) {
            logger.info("User Profile Update")
            registrationHookRequest.data.userProfileUpdate?.forEach { logger.info("Attribute ${it.key} : ${it.value}") }
        }

        val response = RegistrationHookResponse(
            commands = listOf(
                RegistrationCommand.ProgressiveProfileCommand(
                    value = mapOf(
                        Pair("email", "example@example.com"),
                        Pair("company", "Example Inc.")
                    )
                ),
                RegistrationCommand.RegistrationActionCommand(
                    value = RegistrationValue(
                        registration = REGISTRATION.ALLOW
                    )
                )
            )
        )
        logger.info("Response: $response")
        return response
    }
}