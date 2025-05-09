package dev.studiohudson.oktaSidecar.service

import com.okta.sdk.client.AuthorizationMode
import com.okta.sdk.client.Clients
import com.okta.sdk.resource.client.ApiClient
import dev.studiohudson.oktaSidecar.model.okta.OktaClient
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils
import java.io.FileInputStream

@Component
@EnableConfigurationProperties(OktaClient::class)
class ServiceBeans (
    private val oktaClient: OktaClient
) {

    @Bean
    fun initializeOktaSDK(): ApiClient {
        val file = ResourceUtils.getFile("classpath:${oktaClient.privateKey}")
        val input = FileInputStream(file)
        val client = Clients.builder()
            .setOrgUrl("https://${oktaClient.hostname}")
            .setAuthorizationMode(AuthorizationMode.PRIVATE_KEY)
            .setClientId(oktaClient.clientId)
            .setKid(oktaClient.kid) // optional
            .setScopes(HashSet(oktaClient.scopes))
            .setPrivateKey(input)
            .build()
        return client
    }
}