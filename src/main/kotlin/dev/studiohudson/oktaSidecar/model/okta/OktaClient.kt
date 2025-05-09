package dev.studiohudson.oktaSidecar.model.okta

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "okta-client")
data class OktaClient (
    val hostname: String,
    val clientId: String,
    val kid: String,
    val scopes: ArrayList<String>,
    val privateKey: String,
){
}