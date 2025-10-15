package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService
import com.example.amphibians.network.AmphibiansPhoto

interface AmphibiansPhotosRepository {
    suspend fun getAmphibiansPhotos(): List<AmphibiansPhoto>
}

class NetworkAmphibiansPhotosRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansPhotosRepository {
    override suspend fun getAmphibiansPhotos(): List<AmphibiansPhoto> {
        val response = amphibiansApiService.getPhotos("android")
        return response.items.map {
            AmphibiansPhoto(
                name = it.volumeInfo.title ?: "",
                type = it.volumeInfo.authors?.joinToString(", ") ?: "",
                description = it.volumeInfo.description ?: "",
                imgSrc = it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https") ?: ""
            )
        }
    }
}
