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
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.IngresoDeComponentes
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.EstadoDeVehiculo
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.DetallesDeComponentes
import com.google.gson.Gson

@Composable
fun Navegador(viewModelStoreOwner: ViewModelStoreOwner = LocalViewModelStoreOwner.current!!) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pantallaPrincipal"
    ) {
        // Pantalla Principal
        composable("pantallaPrincipal") {
            val viewModel: AceiteMotViewModel = hiltViewModel(viewModelStoreOwner)
            AreaDePruebas(navController = navController, viewModel)
        }

        // Pantalla Ingreso de Componentes
        composable("pantallaIngresoComponentes") {
            val viewModel: AceiteMotViewModel = hiltViewModel(viewModelStoreOwner)
            IngresoDeComponentes(navController = navController, viewModel)
        }

        // Pantalla Estado del Vehiculo
        composable("pantallaEstadoDeVehiculo") {
            val viewModel: AceiteMotViewModel = hiltViewModel(viewModelStoreOwner)
            EstadoDeVehiculo(navController = navController, viewModel)
        }

        // Pantalla de Detalles
        composable("pantallaDetalles") {
            val viewModel: AceiteMotViewModel = hiltViewModel(viewModelStoreOwner)
            DetallesDeComponentes(navController = navController, viewModel)
        }
    }
}