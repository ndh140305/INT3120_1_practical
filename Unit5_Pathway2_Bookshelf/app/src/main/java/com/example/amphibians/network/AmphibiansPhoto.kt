package com.example.amphibians.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibiansPhoto(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("thumbnail") val imgSrc: String
)

@Serializable
data class BooksResponse(
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String? = "",
    val authors: List<String>? = null,
    val description: String? = "",
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = ""
)
