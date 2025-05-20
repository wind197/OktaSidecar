package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.photos.PhotoMetadata
import dev.studiohudson.oktaSidecar.service.PhotosService
import jakarta.annotation.security.RolesAllowed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController(
    private val photosService: PhotosService
) {

    @GetMapping("/photos")
    @RolesAllowed("photoz")
    fun listPhotos(): List<PhotoMetadata> {
        return photosService.listPhotos()
    }

    @GetMapping("/secret1")
    @RolesAllowed("secret1")
    fun validateSecret1(): Boolean {
        return true
    }
}