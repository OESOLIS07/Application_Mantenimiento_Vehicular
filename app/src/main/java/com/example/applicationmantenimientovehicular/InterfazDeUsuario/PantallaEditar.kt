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
import com.example.applicationmantenimientovehicular.Modelo.AceiteMoto
import com.example.applicationmantenimientovehicular.ViewModel.AceiteMotViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.TextField

@Composable
fun EditarComponente(
    aceiteMoto: AceiteMoto,
    navController: NavController,
    viewModel: AceiteMotViewModel = hiltViewModel()
)
{
    var aceiteNuevoNombre by remember { mutableStateOf(aceiteMoto.nombre)}
    var aceiteNuevaDurabilidad by remember { mutableStateOf(aceiteMoto.durabilidad.toString()) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Pantalla Editar Componente")
        TextField(
            value = aceiteNuevoNombre,
            onValueChange = { aceiteNuevoNombre = it },
            label = { Text("Nuevo nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = aceiteNuevaDurabilidad,
            onValueChange = { aceiteNuevaDurabilidad = it },
            label = { Text("Nueva durabilidad del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Actualizamos el Producto en la base de datos
                viewModel.update(aceiteMoto.copy(nombre = aceiteNuevoNombre, durabilidad = aceiteNuevaDurabilidad.toInt()))
                navController.popBackStack() // Regresamos a la pantalla anterior
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar cambios")
        }
    }
}