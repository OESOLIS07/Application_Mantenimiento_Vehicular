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
import androidx.room.util.TableInfo
import com.example.applicationmantenimientovehicular.ViewModel.AceiteMotViewModel

@Composable
fun IngresoDeComponentes(
    navController: NavController,
    viewModel: AceiteMotViewModel = hiltViewModel()
)
{
    var marca by remember { mutableStateOf("") } // Estado para la Marca del Producto
    var durabilidad by remember { mutableStateOf("") } // Estado para la Durabilidad del Producto
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
            Text("Aceite")
            //Text(if (textFieldEnabled) "Desactivar TextField" else "Activar TextField")
        }
        if (textFieldVisible) {
            OutlinedTextField(
                value = marca,
                onValueChange = { marca= it },
                label = { Text("Ingrese la Marca del Producto") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = durabilidad,
                onValueChange = { durabilidad= it },
                label = { Text("Ingrese la Durabilidad del Producto") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        //Boton para Guardar el nuevo Componente
        Button(
            onClick = {
                // Navegar a la Pantalla de Detalles
                navController.navigate("pantallaDetalles")
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}