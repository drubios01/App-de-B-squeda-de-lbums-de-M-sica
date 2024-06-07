package com.example.busquedadealbumsdemusica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.busquedadealbumsdemusica.ui.navigation.ITunesNavHost
import com.example.busquedadealbumsdemusica.viewmodel.ITunesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: ITunesViewModel = hiltViewModel()
            ITunesNavHost(navController = navController, viewModel = viewModel)
        }
    }
}
