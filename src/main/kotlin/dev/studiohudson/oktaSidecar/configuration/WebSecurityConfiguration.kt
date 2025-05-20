package dev.studiohudson.oktaSidecar.configuration

import dev.studiohudson.oktaSidecar.model.config.BasicUsersConfig
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
@EnableConfigurationProperties(BasicUsersConfig::class)
class WebSecurityConfiguration(
    val basicUsersConfig: BasicUsersConfig
) {

    @Bean
    @Order(1)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
            authorizeHttpRequests {
                authorize("/test/**", authenticated)
                authorize("/event-hooks/**", authenticated)
                authorize("/**", permitAll)
            }
            httpBasic {

            }
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun userDetailsService(
        passwordEncoder: PasswordEncoder
    ): UserDetailsService {
        val userBuilder = User.builder().passwordEncoder(passwordEncoder::encode)
        val users = basicUsersConfig.users.map {
                userConfig -> userBuilder
                    .username(userConfig.username)
                    .password(userConfig.password)
                    .roles(userConfig.role)
                    .build()
        }
        return InMemoryUserDetailsManager(users)
    }

}