package com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.applicationmantenimientovehicular.Modelo.Kilometraje

@Dao
interface KilometrajeDao
{
    @Insert
    suspend fun insert(kilometraje: Kilometraje)

    @Update
    suspend fun update(kilometraje: Kilometraje)

    @Query("SELECT * FROM kilometraje")
    fun getAllKilometraje(): LiveData<List<Kilometraje>>

    @Query("DELETE FROM kilometraje")
    suspend fun deleteAllKilometraje()

    @Delete
    suspend fun delete(kilometraje: Kilometraje)
}