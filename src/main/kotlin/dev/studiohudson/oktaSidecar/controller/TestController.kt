package dev.studiohudson.oktaSidecar.controller

import dev.studiohudson.oktaSidecar.model.photos.PhotoMetadata
import dev.studiohudson.oktaSidecar.service.PhotosService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController(
    private val photosService: PhotosService
) {

    @GetMapping("/photos")
    fun listPhotos(): List<PhotoMetadata> {
        return photosService.listPhotos()
    }
}