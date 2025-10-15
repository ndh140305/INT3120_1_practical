package com.example.amphibians.network

import kotlinx.serialization.json.Json
import retrofit2.http.GET
import retrofit2.http.Query

private val json = Json { ignoreUnknownKeys = true }

interface AmphibiansApiService {
    @GET("volumes")
    suspend fun getPhotos(@Query("q") query: String): BooksResponse
}
