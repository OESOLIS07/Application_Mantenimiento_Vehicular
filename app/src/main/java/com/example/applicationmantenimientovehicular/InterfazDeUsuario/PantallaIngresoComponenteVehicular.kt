package com.example.applicationmantenimientovehicular.InterfazDeUsuario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Pantalla Ingreso de Componentes")
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