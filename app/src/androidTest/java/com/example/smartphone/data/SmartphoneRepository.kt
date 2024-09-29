package com.example.smartphone.data

import androidx.lifecycle.LiveData

class SmartphoneRepository(private val smartphoneDao: SmartphoneDao) {

    val allSmartphones: LiveData<List<Smartphone>> = smartphoneDao.getAllSmartphones()

    suspend fun insert(smartphone: Smartphone) {
        smartphoneDao.insert(smartphone)
    }
}
