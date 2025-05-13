package dev.studiohudson.oktaSidecar.model.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "okta-client")
data class OktaConfig (
    val hostname: String,
    val clientId: String,
    val kid: String,
    val scopes: ArrayList<String>,
    val privateKey: String,
){
}