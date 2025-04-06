package com.example.applicationmantenimientovehicular.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationmantenimientovehicular.Datos.AceiteMotoRepository
import com.example.applicationmantenimientovehicular.Modelo.AceiteMoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AceiteMotViewModel @Inject constructor(
    private val repository: AceiteMotoRepository
) : ViewModel()
{
    fun insert(aceiteMoto: AceiteMoto) = viewModelScope.launch {
        repository.insert(aceiteMoto)
    }

    fun update(aceiteMoto: AceiteMoto) = viewModelScope.launch {
        repository.update(aceiteMoto)
    }
    fun deleteAceiteMoto(aceiteMoto: AceiteMoto) {
        viewModelScope.launch {
            repository.delete(aceiteMoto)
        }
    }
}