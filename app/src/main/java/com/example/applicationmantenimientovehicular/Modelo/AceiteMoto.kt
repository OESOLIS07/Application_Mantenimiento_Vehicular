package com.example.applicationmantenimientovehicular.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "aceiteMoto")
data class AceiteMoto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String = "",
    val durabilidad: Int = 0,
    val isSelected:   Boolean = false
): Serializable
