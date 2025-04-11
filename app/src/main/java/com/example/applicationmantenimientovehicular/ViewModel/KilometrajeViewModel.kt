package com.example.applicationmantenimientovehicular.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationmantenimientovehicular.Datos.KilometrajeRepository
import com.example.applicationmantenimientovehicular.Modelo.Kilometraje
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KilometrajeViewModel @Inject constructor(
    private val repository: KilometrajeRepository
) : ViewModel()
{
    val allKilometraje: LiveData<List<Kilometraje>> get() = repository.getAllKilometraje()

    fun insert(kilometraje: Kilometraje) = viewModelScope.launch {
        repository.insert(kilometraje)
    }

    fun update(kilometraje: Kilometraje) = viewModelScope.launch {
        repository.update(kilometraje)
    }
    fun deleteKilometraje(kilometraje: Kilometraje) {
        viewModelScope.launch {
            repository.delete(kilometraje)
        }
    }

    fun deleteAllKilometraje() = viewModelScope.launch {
        repository.deleteAllKilometraje()
    }
}