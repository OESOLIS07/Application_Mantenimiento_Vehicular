package com.example.applicationmantenimientovehicular.Datos

import androidx.lifecycle.LiveData
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.KilometrajeDao
import com.example.applicationmantenimientovehicular.Modelo.Kilometraje
import javax.inject.Inject

class KilometrajeRepository @Inject constructor(private val kilometrajeDao: KilometrajeDao)
{
    fun getAllKilometraje(): LiveData<List<Kilometraje>> {
        return kilometrajeDao.getAllKilometraje()
    }

    suspend fun insert(kilometraje: Kilometraje) {
        kilometrajeDao.insert(kilometraje)
    }

    suspend fun update(kilometraje: Kilometraje) {
        kilometrajeDao.update(kilometraje)
    }

    suspend fun deleteAllKilometraje() {
        kilometrajeDao.deleteAllKilometraje()
    }

    suspend fun delete(kilometraje: Kilometraje) {
        kilometrajeDao.delete(kilometraje)
    }
}