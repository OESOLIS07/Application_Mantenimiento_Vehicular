package com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.applicationmantenimientovehicular.Modelo.Componente

@Dao
interface ComponenteDao
{
    @Insert
    suspend fun insert(componente: Componente)

    @Update
    suspend fun update(componente: Componente)

    @Query("SELECT * FROM componenteVehicular")
    fun getAllComponete(): LiveData<List<Componente>>

    @Query("DELETE FROM componenteVehicular")
    suspend fun deleteComponente()

    @Delete
    suspend fun delete(componente: Componente)
}