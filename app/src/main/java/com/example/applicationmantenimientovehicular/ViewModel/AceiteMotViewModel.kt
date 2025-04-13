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
class AceiteMotViewModel @Inject constructor(
    private val repository: ComponenteRepository
) : ViewModel()
{
    val allAceiteMoto: LiveData<List<Componente>> get() = repository.getAllAceiteMoto()

    fun insert(aceiteMoto: Componente) = viewModelScope.launch {
        repository.insert(aceiteMoto)
    }

    fun update(aceiteMoto: Componente) = viewModelScope.launch {
        repository.update(aceiteMoto)
    }
    fun deleteAceiteMoto(aceiteMoto: Componente) {
        viewModelScope.launch {
            repository.delete(aceiteMoto)
        }
    }

    fun deleteAllAceiteMoto() = viewModelScope.launch {
        repository.deleteAllAceiteMoto()
    }
}