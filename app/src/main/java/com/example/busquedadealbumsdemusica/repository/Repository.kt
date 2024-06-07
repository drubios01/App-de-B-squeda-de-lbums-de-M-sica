package com.example.busquedadealbumsdemusica.repository

import com.example.busquedadealbumsdemusica.model.Album
import com.example.busquedadealbumsdemusica.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ITunesRepository {
    private val api = RetrofitInstance.api

    suspend fun searchAlbums(term: String): List<Album> {
        return withContext(Dispatchers.IO) {
            val response = api.searchAlbums(term)
            response.results
        }
    }
}
