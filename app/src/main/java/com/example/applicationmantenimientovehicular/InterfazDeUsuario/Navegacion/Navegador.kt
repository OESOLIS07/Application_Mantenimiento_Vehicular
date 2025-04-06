package com.example.applicationmantenimientovehicular.InterfazDeUsuario.Navegacion

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.AreaDePruebas
import com.example.applicationmantenimientovehicular.ViewModel.AceiteMotViewModel
import com.google.gson.Gson

@Composable
fun Navegador(viewModelStoreOwner: ViewModelStoreOwner = LocalViewModelStoreOwner.current!!) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pantallaPrincipal"
    ) {
        // Pantalla principal
        composable("pantallaPrincipal") {
            val viewModel: AceiteMotViewModel = hiltViewModel(viewModelStoreOwner)
            AreaDePruebas(navController = navController, viewModel)
        }
    }
}