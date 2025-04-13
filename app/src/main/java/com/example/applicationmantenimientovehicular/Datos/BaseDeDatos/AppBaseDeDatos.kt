package com.example.applicationmantenimientovehicular.Datos.BaseDeDatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.ComponenteDao
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.KilometrajeDao
import com.example.applicationmantenimientovehicular.Modelo.Componente
import com.example.applicationmantenimientovehicular.Modelo.Kilometraje

@Database(entities = [Componente::class, Kilometraje::class], version = 2,exportSchema = false)
abstract class AppBaseDeDatos: RoomDatabase()
{
    abstract fun componenteDao(): ComponenteDao
    abstract fun kilometrajeDao(): KilometrajeDao

    companion object {
        @Volatile
        private var Instancia: AppBaseDeDatos? = null

        fun getBaseDeDatos(context: Context): AppBaseDeDatos {
            return Instancia ?: synchronized(this) {
                val newInstancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppBaseDeDatos::class.java,
                    "App_BaseDeDatos"
                ).build()
                Instancia = newInstancia
                newInstancia
            }
        }
    }
}