package com.example.smartphone

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "smartphone_table")
data class Smartphone(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val brand: String,
    val model: String,
    val price: Double,
    val storage: Int
)
