package com.example.busquedadealbumsdemusica.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busquedadealbumsdemusica.model.Album
import com.example.busquedadealbumsdemusica.repository.ITunesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ITunesViewModel : ViewModel() {
    private val repository = ITunesRepository()

    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums: StateFlow<List<Album>> = _albums

    fun searchAlbums(term: String) {
        viewModelScope.launch {
            val results = repository.searchAlbums(term)
            _albums.value = results
        }
    }
}
