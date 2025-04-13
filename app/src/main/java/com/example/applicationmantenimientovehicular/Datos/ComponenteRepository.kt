package com.example.applicationmantenimientovehicular.Datos

import androidx.lifecycle.LiveData
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.ComponenteDao
import com.example.applicationmantenimientovehicular.Modelo.Componente
import javax.inject.Inject

class ComponenteRepository @Inject constructor(private val componenteDao: ComponenteDao)
{
    fun getAllComponente(): LiveData<List<Componente>> {
        return componenteDao.getAllComponete()
    }

    suspend fun insert(componente: Componente) {
        componenteDao.insert(componente)
    }

    suspend fun update(componente: Componente) {
        componenteDao.update(componente)
    }

    suspend fun deleteAllComponente() {
        componenteDao.deleteComponente()
    }

    suspend fun delete(componente: Componente) {
        componenteDao.delete(componente)
    }
}