package com.example.smartphone.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SmartphoneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(smartphone: Smartphone)

    @Query("SELECT * FROM smartphone_table")
    fun getAllSmartphones(): LiveData<List<Smartphone>>
}

