package com.example.applicationmantenimientovehicular.DI

import android.content.Context
import com.example.applicationmantenimientovehicular.Datos.AceiteMotoRepository
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.AppBaseDeDatos
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.AceiteMotoDao
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.KilometrajeDao
import com.example.applicationmantenimientovehicular.Datos.KilometrajeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModulo
{
    @Provides
    @Singleton
    fun provideAppBaseDeDatos(@ApplicationContext context: Context): AppBaseDeDatos {
        return AppBaseDeDatos.getBaseDeDatos(context)
    }

    @Provides
    @Singleton
    fun provideAceiteMotoDao(appBaseDeDatos: AppBaseDeDatos): AceiteMotoDao {
        return appBaseDeDatos.aceiteMotoDao()
    }

    @Provides
    @Singleton
    fun providekilometrajeDao(appBaseDeDatos: AppBaseDeDatos): KilometrajeDao {
        return appBaseDeDatos.kilometrajeDao()
    }

    @Provides
    @Singleton
    fun provideAceiteMotoRepository(aceiteMoto: AceiteMotoDao): AceiteMotoRepository {
        return AceiteMotoRepository(aceiteMoto)
    }

    @Provides
    @Singleton
    fun provideKilometrajeRepository(kilometraje: KilometrajeDao): KilometrajeRepository {
        return KilometrajeRepository (kilometraje)
    }
}