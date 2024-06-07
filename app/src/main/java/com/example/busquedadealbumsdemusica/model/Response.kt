package com.example.busquedadealbumsdemusica.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ITunesResponse(
    @SerialName("resultCount") val resultCount: Int,
    @SerialName("results") val results: List<Album>
)

@Serializable
data class Album(
    @SerialName("collectionName") val collectionName: String,
    @SerialName("artistName") val artistName: String,
    @SerialName("artworkUrl100") val artworkUrl: String = ""
)
