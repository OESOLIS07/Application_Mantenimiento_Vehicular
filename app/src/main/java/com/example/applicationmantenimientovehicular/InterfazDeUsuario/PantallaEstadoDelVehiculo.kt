package com.example.applicationmantenimientovehicular.InterfazDeUsuario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.applicationmantenimientovehicular.ViewModel.ComponenteViewModel

@Composable
fun EstadoDeVehiculo(
    navController: NavController,
    viewModel: ComponenteViewModel = hiltViewModel()
)
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Pantalla Estado del Vehiculo")
    }
}