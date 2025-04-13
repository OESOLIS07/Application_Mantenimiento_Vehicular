package com.example.applicationmantenimientovehicular.InterfazDeUsuario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.applicationmantenimientovehicular.Modelo.Kilometraje
import com.example.applicationmantenimientovehicular.ViewModel.KilometrajeViewModel
import com.example.applicationmantenimientovehicular.ui.theme.ApplicationMantenimientoVehicularTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AreaDePruebas(
    navController: NavController = rememberNavController(), // NavController para navegar
    viewModel: KilometrajeViewModel = hiltViewModel(),
)
{
    var kilometraje by remember { mutableStateOf("") } // Estado para el kilometraje

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text("Pantalla Principal")

        // Campo de texto para el kilometraje del vehiculo
        OutlinedTextField(
            value = kilometraje,
            onValueChange = { kilometraje = it },
            label = { Text("Ingrese el Kilometraje actual") },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Seleccione una opción:")
        //Boton para guardar el kilometraje del vehiculo
        Button(

            onClick = {
                if (kilometraje.isNotBlank()) {
                    // Agrega el kilometraje a la base de datos
                    val newKilometraje = Kilometraje(distancia = kilometraje.toInt())
                    viewModel.insert(newKilometraje)
                }
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Guardar Kilometraje ")
        }
        // Boton para revisar el estado del vehiculo
        Button(
            onClick = {
                // Navegar a la Pantalla de Estado del Vehículo
                navController.navigate("pantallaEstadoDeVehiculo")
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Revisar estado del Vehículo")
        }
        //Boton para ingresar componentes vehiculares
        Button(
            onClick = {
                // Navegar a la Pantalla de Ingreso de Componentes
                navController.navigate("pantallaIngresoComponentes")
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Ingresar Componentes")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun VistaPreviaDeListaDeTareasEnPantalla() {
    ApplicationMantenimientoVehicularTheme{
        AreaDePruebas() // Previsualización de la pantalla
    }
}