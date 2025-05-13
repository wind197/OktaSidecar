package dev.studiohudson.oktaSidecar.model.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "photos-service")
data class PhotosConfig(
    val hostname: String,
    val username: String,
    val password: String
) {}
