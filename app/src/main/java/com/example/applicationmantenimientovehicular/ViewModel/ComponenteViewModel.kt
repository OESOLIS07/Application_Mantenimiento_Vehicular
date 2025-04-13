package com.example.applicationmantenimientovehicular.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationmantenimientovehicular.Datos.ComponenteRepository
import com.example.applicationmantenimientovehicular.Modelo.Componente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComponenteViewModel @Inject constructor(
    private val repository: ComponenteRepository
) : ViewModel()
{
    val allComponente: LiveData<List<Componente>> get() = repository.getAllComponente()

    fun insert(componente: Componente) = viewModelScope.launch {
        repository.insert(componente)
    }

    fun update(componente: Componente) = viewModelScope.launch {
        repository.update(componente)
    }
    fun deleteComponente(componente: Componente) {
        viewModelScope.launch {
            repository.delete(componente)
        }
    }

    fun deleteAllComponente() = viewModelScope.launch {
        repository.deleteAllComponente()
    }
}