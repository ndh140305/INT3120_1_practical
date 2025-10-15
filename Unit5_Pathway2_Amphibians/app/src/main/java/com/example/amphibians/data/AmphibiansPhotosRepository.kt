package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService
import com.example.amphibians.network.AmphibiansPhoto

interface AmphibiansPhotosRepository {
    suspend fun getAmphibiansPhotos(): List<AmphibiansPhoto>
}

class NetworkAmphibiansPhotosRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansPhotosRepository {
    override suspend fun getAmphibiansPhotos(): List<AmphibiansPhoto> = amphibiansApiService.getPhotos()
}
