package com.example.applicationmantenimientovehicular.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "kilometraje")
data class Kilometraje(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val distancia: Int,
    val isSelected: Boolean = false
) : Serializable
