package dev.studiohudson.oktaSidecar.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync
class AsyncConfiguration {

    @Bean(name = ["async-light"])
    fun asyncExecutorLight(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2
        executor.maxPoolSize = 2
        executor.queueCapacity = 100
        executor.setThreadNamePrefix("async-light-")
        executor.initialize()
        return executor
    }

    @Bean(name = ["async-heavy"])
    fun asyncExecutorHeavy(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2
        executor.maxPoolSize = 2
        executor.queueCapacity = 100
        executor.setThreadNamePrefix("async-heavy-")
        executor.initialize()
        return executor
    }
}