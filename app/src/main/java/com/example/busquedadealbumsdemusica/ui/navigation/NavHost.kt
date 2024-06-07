package com.example.busquedadealbumsdemusica.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.busquedadealbumsdemusica.ui.screens.SearchScreen
import com.example.busquedadealbumsdemusica.ui.screens.ResultsScreen
import com.example.busquedadealbumsdemusica.viewmodel.ITunesViewModel

@Composable
fun ITunesNavHost(navController: NavHostController, modifier: Modifier = Modifier, viewModel: ITunesViewModel) {
    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            SearchScreen(navController = navController, viewModel = viewModel)
        }
        composable("results") {
            ResultsScreen(navController = navController, viewModel = viewModel)
        }
    }
}
