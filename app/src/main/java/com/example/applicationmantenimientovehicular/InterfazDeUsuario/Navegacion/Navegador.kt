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
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.PantallaPricipal
import com.example.applicationmantenimientovehicular.ViewModel.ComponenteViewModel
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.IngresoDeComponentes
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.EstadoDeVehiculo
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.DetallesDeComponentes
import com.example.applicationmantenimientovehicular.InterfazDeUsuario.EditarComponente
import com.example.applicationmantenimientovehicular.ViewModel.KilometrajeViewModel
import com.example.applicationmantenimientovehicular.Modelo.Componente
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
            val viewModel: KilometrajeViewModel = hiltViewModel(viewModelStoreOwner)
            PantallaPricipal(navController = navController, viewModel)
        }

        // Pantalla Ingreso de Componentes
        composable("pantallaIngresoComponentes") {
            val viewModel: ComponenteViewModel = hiltViewModel(viewModelStoreOwner)
            IngresoDeComponentes(navController = navController, viewModel)
        }

        // Pantalla Editar Componente
        composable(
            route = "pantallaEditarComponente/{componenteJson}",
            arguments = listOf(
                navArgument("componenteJson") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            // Recuperamos el objeto Componente
            val json = backStackEntry.arguments?.getString("componenteJson")
            val componente = Gson().fromJson(json, Componente::class.java)

            val viewModel: ComponenteViewModel = hiltViewModel(viewModelStoreOwner)
            if (componente != null) {
                EditarComponente(
                    componente = componente, // Pasamos el objeto Componente
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }

        // Pantalla Estado del Vehiculo
        composable("pantallaEstadoDeVehiculo") {
            val viewModel: ComponenteViewModel = hiltViewModel(viewModelStoreOwner)
            EstadoDeVehiculo(navController = navController, viewModel)
        }

        // Pantalla de Detalles
        composable("pantallaDetalles") {
            val viewModel: ComponenteViewModel = hiltViewModel(viewModelStoreOwner)
            DetallesDeComponentes(navController = navController, viewModel)
        }
    }
}