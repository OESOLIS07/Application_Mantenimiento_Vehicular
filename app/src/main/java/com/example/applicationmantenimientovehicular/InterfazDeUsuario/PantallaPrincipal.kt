package com.example.applicationmantenimientovehicular.InterfazDeUsuario

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.applicationmantenimientovehicular.Modelo.AceiteMoto
import com.example.applicationmantenimientovehicular.Modelo.Kilometraje
import com.example.applicationmantenimientovehicular.ViewModel.AceiteMotViewModel
import com.example.applicationmantenimientovehicular.ViewModel.KilometrajeViewModel
import com.example.applicationmantenimientovehicular.ui.theme.ApplicationMantenimientoVehicularTheme
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.math.abs

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