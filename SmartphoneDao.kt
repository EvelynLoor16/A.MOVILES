package com.example.smartphone

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SmartphoneDao {

    // Método para insertar un smartphone
    @Insert
    suspend fun insert(smartphone: Smartphone)

    // Método para obtener todos los smartphones desde la base de datos
    @Query("SELECT * FROM smartphone_table")
    suspend fun getAllSmartphones(): List<Smartphone>
}



