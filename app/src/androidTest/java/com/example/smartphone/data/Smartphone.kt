package com.example.smartphone.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "smartphone_table")
data class Smartphone(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val marca: String,
    val modelo: String,
    val precio: Double,
    val almacenamiento: Int,
    val sistemaOperativo: String
)

