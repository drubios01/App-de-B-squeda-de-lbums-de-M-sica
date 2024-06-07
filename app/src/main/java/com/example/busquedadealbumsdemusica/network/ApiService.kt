package com.example.busquedadealbumsdemusica.network

import com.example.busquedadealbumsdemusica.model.ITunesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun searchAlbums(
        @Query("term") term: String,
        @Query("entity") entity: String = "album",
        @Query("attribute") attribute: String = "albumTerm"
    ): ITunesResponse
}
