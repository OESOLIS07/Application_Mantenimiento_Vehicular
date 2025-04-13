package com.example.applicationmantenimientovehicular.InterfazDeUsuario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.applicationmantenimientovehicular.Modelo.Componente
import com.example.applicationmantenimientovehicular.ViewModel.ComponenteViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.TextField

@Composable
fun EditarComponente(
    componente: Componente,
    navController: NavController,
    viewModel: ComponenteViewModel = hiltViewModel()
)
{
    var componenteNuevoNombre by remember { mutableStateOf(componente.nombre)}
    var componenteNuevaDurabilidad by remember { mutableStateOf(componente.durabilidad.toString())}
    var componenteNuevoKilometraje by remember { mutableStateOf(componente.kilometrajeComponente.toString())}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Pantalla Editar Componente")
        TextField(
            value = componenteNuevoNombre,
            onValueChange = { componenteNuevoNombre = it },
            label = { Text("Nuevo nombre del Componente") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = componenteNuevaDurabilidad,
            onValueChange = { componenteNuevaDurabilidad = it },
            label = { Text("Nueva durabilidad del Componente") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = componenteNuevoKilometraje,
            onValueChange = { componenteNuevoKilometraje = it },
            label = { Text("Nuevo Kilometraje del Componente") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Actualizamos el Componente en la base de datos
                viewModel.update(componente.copy(nombre = componenteNuevoNombre, durabilidad = componenteNuevaDurabilidad.toInt(), kilometrajeComponente = componenteNuevoKilometraje.toInt()))
                navController.popBackStack() // Regresamos a la pantalla anterior
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar cambios")
        }
    }
}