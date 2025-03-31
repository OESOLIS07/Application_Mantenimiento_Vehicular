package com.example.applicationmantenimientovehicular.Datos.BaseDeDatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.AceiteMotoDao
import com.example.applicationmantenimientovehicular.Modelo.AceiteMoto

@Database(entities = [AceiteMoto::class], version = 1,exportSchema = false)
abstract class AppBaseDeDatos: RoomDatabase()
{
    abstract fun aceiteMotoDao(): AceiteMotoDao

    companion object {
        @Volatile
        private var Instancia: AppBaseDeDatos? = null

        fun getBaseDeDatos(context: Context): AppBaseDeDatos {
            return Instancia ?: synchronized(this) {
                val newInstancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppBaseDeDatos::class.java,
                    "aceiteMoto_BaseDeDatos"
                ).build()
                Instancia = newInstancia
                newInstancia
            }
        }
    }
}