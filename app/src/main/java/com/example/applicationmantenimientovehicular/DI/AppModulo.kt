package com.example.applicationmantenimientovehicular.DI

import android.content.Context
import com.example.applicationmantenimientovehicular.Datos.ComponenteRepository
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.AppBaseDeDatos
import com.example.applicationmantenimientovehicular.Datos.BaseDeDatos.Interfaz.ComponenteDao
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
    fun provideComponenteDao(appBaseDeDatos: AppBaseDeDatos): ComponenteDao {
        return appBaseDeDatos.componenteDao()
    }

    @Provides
    @Singleton
    fun provideComponenteRepository(componenteDao: ComponenteDao): ComponenteRepository {
        return ComponenteRepository(componenteDao)
    }

    @Provides
    @Singleton
    fun providekilometrajeDao(appBaseDeDatos: AppBaseDeDatos): KilometrajeDao {
        return appBaseDeDatos.kilometrajeDao()
    }


    @Provides
    @Singleton
    fun provideKilometrajeRepository(kilometrajeDao: KilometrajeDao): KilometrajeRepository {
        return KilometrajeRepository (kilometrajeDao)
    }
}