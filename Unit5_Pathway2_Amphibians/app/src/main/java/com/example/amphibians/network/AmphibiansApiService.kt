package com.example.amphibians.network

import kotlinx.serialization.json.Json
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com/"

private val json = Json { ignoreUnknownKeys = true }

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getPhotos(): List<AmphibiansPhoto>
}
