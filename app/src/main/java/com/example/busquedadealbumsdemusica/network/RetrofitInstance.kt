package com.example.busquedadealbumsdemusica.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

object RetrofitInstance {
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
