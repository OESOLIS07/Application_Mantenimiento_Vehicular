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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.applicationmantenimientovehicular.Modelo.Componente
import com.example.applicationmantenimientovehicular.ViewModel.AceiteMotViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.math.abs
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetallesDeComponentes(
    navController: NavController,
    viewModel: AceiteMotViewModel = hiltViewModel()
)
{
    // Observamos el LiveData usando observeAsState
    val aceitesMoto by viewModel.allAceiteMoto.observeAsState(emptyList<Componente>())

    var aceiteMotoToDelete by remember { mutableStateOf<Componente?>(null) }
    var cancelSwipeAction by remember { mutableStateOf<(() -> Unit)?>(null) }
    var isRefreshing by remember { mutableStateOf(false) }

    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            isRefreshing = false
        }
    )

    Scaffold(
        floatingActionButton = {
            // Botón flotante con ícono de "CHECK"
            FloatingActionButton(
                onClick = {
                    // Volver a pantalla Principal
                    navController.navigate("pantallaPrincipal")
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add, // Ícono de "agregar"
                    contentDescription = "Agregar Tarea"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .pullRefresh(pullRefreshState)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(aceitesMoto) { aceiteMoto ->
                        AceiteCard(
                            aceiteMoto = aceiteMoto,
                            onClick = { viewModel.update(aceiteMoto.copy(isSelected = !aceiteMoto.isSelected))},
                            onSwipe = {
                                aceiteMotoToDelete = aceiteMoto
                                cancelSwipeAction = null
                            },
                            onEditClick = {
                                val json = Gson().toJson(aceiteMoto)
                                val encodedJson = URLEncoder.encode(json, StandardCharsets.UTF_8.toString())
                                navController.navigate("pantallaEditarComponente/$encodedJson")
                            },
                            onCancelSwipe = { cancelSwipeAction = it }
                        )
                    }
                }
                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = pullRefreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }


        }
    }
}

@Composable
fun AceiteCard(
    aceiteMoto: Componente,
    onClick: () -> Unit,
    onSwipe: () -> Unit,
    onEditClick: () -> Unit,
    onCancelSwipe: (() -> Unit) -> Unit
) {
    val offsetX = remember { Animatable(0f) } // Controla la animación del desplazamiento
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .offset { IntOffset(offsetX.value.toInt(), 0) } // Desplaza la tarjeta en X
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        // Si el desplazamiento es suficiente, eliminar el item
                        if (abs(offsetX.value) > 300f) {
                            scope.launch {
                                offsetX.animateTo(
                                    targetValue = if (offsetX.value > 0) 1000f else -1000f, // Se desliza fuera de la pantalla
                                    animationSpec = tween(durationMillis = 300)
                                )
                                onSwipe() // Llama a la acción de eliminar
                            }
                        } else {
                            // Si el desplazamiento es pequeño, regresar a la posición original
                            scope.launch {
                                offsetX.animateTo(0f, animationSpec = tween(300))
                            }
                        }
                    }
                ) { _, dragAmount ->
                    scope.launch {
                        offsetX.snapTo(offsetX.value + dragAmount) // Mueve la tarjeta con el gesto
                    }
                }
            }
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (aceiteMoto.isSelected) Color.Red else Color.White
        ),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = aceiteMoto.nombre,
                modifier = Modifier.weight(1f)
            )
            Text("Durabilidad:  ")
            Text(
                text = aceiteMoto.durabilidad.toString(),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar",
                modifier = Modifier
                    .clickable { onEditClick() }
                    .padding(start = 8.dp)
            )

        }
    }
    LaunchedEffect(key1 = aceiteMoto) {
        onCancelSwipe {
            scope.launch { offsetX.animateTo(0f, tween(300)) }
        }
    }
    onCancelSwipe {
        scope.launch { offsetX.animateTo(0f, tween(300)) }
    }
}