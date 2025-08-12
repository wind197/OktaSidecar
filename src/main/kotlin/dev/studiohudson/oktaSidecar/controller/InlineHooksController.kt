package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.registrationHook.response.RegistrationHookResponse
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.request.InlineHookRequest
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.SamlHookResponse
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.samlAssertionHook.response.Value
import dev.studiohudson.oktaSidecar.model.okta.inlineHooks.tokenHook.response.TokenHookResponse
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
        @RequestBody tokenHookRequest: InlineHookRequest.TokenHookRequest
    ) : TokenHookResponse {
        logger.info("Request: $tokenHookRequest")

        logger.info("Identity Claims")
        tokenHookRequest.data.identity.claims.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        logger.info("Access Claims")
        tokenHookRequest.data.access.claims.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        val response = TokenHookResponse(
            commands = listOf(
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
            commands = listOf(
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

    @PostMapping("userImport")
    fun userImportHook(
        @RequestBody userImportHookRequest: InlineHookRequest.UserImportHookRequest
    ) : UserImportHookResponse {
        logger.info("Request: $userImportHookRequest")

        logger.info("User Profile")
        userImportHookRequest.data.user.profile.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        logger.info("App User Profile")
        userImportHookRequest.data.appUser.profile.forEach { logger.info("Claim ${it.key} : ${it.value}") }

        val response = UserImportHookResponse(
            commands = listOf(
                UserImportHookResponse.Command(
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
        @RequestBody registrationHookRequest: InlineHookRequest.RegistrationHookRequest
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
                RegistrationHookResponse.Command.ProgressiveProfileCommand(
//                    type = "com.okta.user.progressive.profile.update",
                    value = mapOf(
                        Pair("email", "example@example.com"),
                        Pair("company", "Example Inc.")
                    )
                ),
                RegistrationHookResponse.Command.RegistrationCommand(
//                    type = "com.okta.user.progressive.profile.update",
                    value = RegistrationHookResponse.Command.RegistrationCommand.Value(
                        registration = RegistrationHookResponse.Command.RegistrationCommand.Value.REGISTRATION.ALLOW
                    )
                )
            )
        )
        logger.info("Response: $response")
        return response
    }
}