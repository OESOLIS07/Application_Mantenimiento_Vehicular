package com.example.applicationmantenimientovehicular.Datos

import androidx.lifecycle.LiveData
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.AceiteMotoDao
import com.example.applicationmantenimientovehicular.Modelo.AceiteMoto
import javax.inject.Inject

class AceiteMotoRepository @Inject constructor(private val aceiteMotoDao: AceiteMotoDao)
{
    suspend fun insert(aceiteMoto: AceiteMoto) {
        aceiteMotoDao.insert(aceiteMoto)
    }

    suspend fun update(aceiteMoto: AceiteMoto) {
        aceiteMotoDao.update(aceiteMoto)
    }

    suspend fun delete(aceiteMoto: AceiteMoto) {
        aceiteMotoDao.delete(aceiteMoto)
    }
}