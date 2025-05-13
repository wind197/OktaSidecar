package dev.studiohudson.oktaSidecar.service

import com.okta.sdk.client.AuthorizationMode
import com.okta.sdk.client.Clients
import com.okta.sdk.resource.client.ApiClient
import dev.studiohudson.oktaSidecar.model.config.OktaConfig
import dev.studiohudson.oktaSidecar.model.config.PhotosConfig
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils
import org.springframework.web.client.RestClient
import java.io.FileInputStream
import java.util.*
import kotlin.collections.HashSet

@Component
@EnableConfigurationProperties(OktaConfig::class, PhotosConfig::class)
class WebClientServices(
    private val oktaConfig: OktaConfig,
    private val photosConfig: PhotosConfig,
    private val restClientBuilder: RestClient.Builder
) {

    @Bean
    fun initializeOktaSDK(): ApiClient {
        val file = ResourceUtils.getFile("classpath:${oktaConfig.privateKey}")
        val input = FileInputStream(file)
        val client = Clients.builder()
            .setOrgUrl("https://${oktaConfig.hostname}")
            .setAuthorizationMode(AuthorizationMode.PRIVATE_KEY)
            .setClientId(oktaConfig.clientId)
            .setKid(oktaConfig.kid) // optional
            .setScopes(HashSet(oktaConfig.scopes))
            .setPrivateKey(input)
            .build()
        return client
    }

    @Bean
    @Qualifier("photosClient")
    fun initializePhotosService(): RestClient {
        val base64EncodedSecret = Base64.getEncoder().encodeToString("${photosConfig.username}:${photosConfig.password}".toByteArray())
        return restClientBuilder.baseUrl(photosConfig.hostname)
            .defaultHeader("Authorization", "Basic $base64EncodedSecret")
            .build()
    }

    @Bean
    @Qualifier("basicClient")
    fun initializeBasicService(): RestClient {
        val base64EncodedSecret = Base64.getEncoder().encodeToString("username:password".toByteArray())
        return restClientBuilder.baseUrl("http://localhost:8082")
            .defaultHeader("Authorization", "Basic $base64EncodedSecret")
            .build()
    }
}