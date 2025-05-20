package dev.studiohudson.oktaSidecar.model.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "okta-sidecar.security")
data class BasicUsersConfig(
    val users: List<UserConfig>
) {
    data class UserConfig(
        val username: String,
        val password: String,
        val role: String
    )
}
