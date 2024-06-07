package com.example.busquedadealbumsdemusica.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.busquedadealbumsdemusica.viewmodel.ITunesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, viewModel: ITunesViewModel) {
    var searchTerm by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscar Álbums", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = searchTerm,
                    onValueChange = { searchTerm = it },
                    label = { Text("Buscar...") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.searchAlbums(searchTerm)
                        navController.navigate("results")
                    }
                ) {
                    Text("Buscar")
                }
            }
        }
    }
}
