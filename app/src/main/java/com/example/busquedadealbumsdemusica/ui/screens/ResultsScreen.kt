package com.example.busquedadealbumsdemusica.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.busquedadealbumsdemusica.model.Album
import com.example.busquedadealbumsdemusica.viewmodel.ITunesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(navController: NavController, viewModel: ITunesViewModel = hiltViewModel()) {
    val albums by viewModel.albums.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultados de la Búsqueda") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(albums) { album ->
                AlbumItem(album)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun AlbumItem(album: Album) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(album.artworkUrl),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = album.collectionName, style = MaterialTheme.typography.titleLarge)
            Text(text = album.artistName, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
