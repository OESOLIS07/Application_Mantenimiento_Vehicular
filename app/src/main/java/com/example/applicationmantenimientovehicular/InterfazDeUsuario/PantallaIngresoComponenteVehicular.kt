package com.example.applicationmantenimientovehicular.InterfazDeUsuario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.applicationmantenimientovehicular.Modelo.Componente
import com.example.applicationmantenimientovehicular.ViewModel.ComponenteViewModel

@Composable
fun IngresoDeComponentes(
    navController: NavController,
    viewModel: ComponenteViewModel = hiltViewModel()
)
{
    var nombre by remember { mutableStateOf("") } // Estado para el Nombre del Componente
    var durabilidad by remember { mutableStateOf("") } // Estado para la Durabilidad del Componente
    var kilometrajeComponente by remember { mutableStateOf("") } // Estado para el Kilometraje del Componente
    var textFieldVisible by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Pantalla Ingreso de Componentes")
        // Boton para seleccionar el Aceite
        Button(
            onClick = {
                textFieldVisible = true
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Ingreso de Componente")
        }
        if (textFieldVisible) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre= it },
                label = { Text("Ingrese el Nombre del Componente") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = durabilidad,
                onValueChange = { durabilidad= it },
                label = { Text("Ingrese la Durabilidad del Componente") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = kilometrajeComponente,
                onValueChange = { kilometrajeComponente= it },
                label = { Text("Ingrese el Kilometraje actual") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        //Boton para Guardar el nuevo Componente
        Button(
            onClick = {
                if (nombre.isNotBlank()) {
                    // Crear un nuevo Componente y lo agrega a la Base de Datos
                    val nuevoComponente = Componente(nombre = nombre, durabilidad = durabilidad.toInt(), kilometrajeComponente = kilometrajeComponente.toInt())
                    viewModel.insert(nuevoComponente)
                    // Navegar a la Pantalla de Detalles
                    navController.navigate("pantallaDetalles")
                }
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Guardar Componente")
        }
    }
}