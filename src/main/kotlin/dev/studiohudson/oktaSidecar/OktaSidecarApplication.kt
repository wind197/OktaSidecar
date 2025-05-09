package dev.studiohudson.oktaSidecar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OktaSidecarApplication

fun main(args: Array<String>) {
    runApplication<OktaSidecarApplication>(*args)
}
