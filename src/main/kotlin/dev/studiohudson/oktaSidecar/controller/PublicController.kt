package dev.studiohudson.oktaSidecar.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/public")
class PublicController {

    @GetMapping("/stats")
    fun listStats(): String {
        return "Stats"
    }
}