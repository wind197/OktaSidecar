package dev.studiohudson.oktaSidecar.service

import dev.studiohudson.oktaSidecar.model.photos.PhotoMetadata
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class PhotosService(
    @Qualifier("photosClient")    private val photosRestClient: RestClient
) {

    fun listPhotos(): List<PhotoMetadata> {
        return photosRestClient.get()
            .uri("/photoz").retrieve().body(object : ParameterizedTypeReference<List<PhotoMetadata>?>() {}).orEmpty()
    }
}