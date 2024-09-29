package com.example.smartphone

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Smartphone::class], version = 1, exportSchema = false)
abstract class SmartphoneDatabase : RoomDatabase() {
    abstract fun smartphoneDao(): SmartphoneDao
}
