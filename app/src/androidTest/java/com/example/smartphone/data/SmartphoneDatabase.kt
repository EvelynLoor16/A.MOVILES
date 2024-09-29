package com.example.smartphone.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Smartphone::class], version = 1, exportSchema = false)
abstract class SmartphoneDatabase : RoomDatabase() {

    abstract fun smartphoneDao(): SmartphoneDao

    companion object {
        @Volatile
        private var INSTANCE: SmartphoneDatabase? = null

        fun getDatabase(context: Context): SmartphoneDatabase {
            // Verifica si la base de datos ya ha sido creada
            return INSTANCE ?: synchronized(this) {
                // Si no existe, la crea
                val instance = Room.databaseBuilder(
                    context.applicationContext.toString(),
                    SmartphoneDatabase::class.java,
                    "smartphone_database"
                )
                    // .fallbackToDestructiveMigration() // Si deseas habilitar la migración automática destructiva
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

private fun Room.databaseBuilder(name: String, factory: Class<SmartphoneDatabase>, s: String): Any {

    return TODO("Provide the return value")
}

