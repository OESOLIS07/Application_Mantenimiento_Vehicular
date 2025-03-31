package com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.applicationmantenimientovehicular.Modelo.AceiteMoto

@Dao
interface AceiteMotoDao
{
    @Insert
    suspend fun insert(aceiteMoto: AceiteMoto)

    @Update
    suspend fun update(aceiteMoto: AceiteMoto)

    @Delete
    suspend fun delete(aceiteMoto: AceiteMoto)
}