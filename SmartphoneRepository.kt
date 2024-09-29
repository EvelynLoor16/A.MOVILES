package com.example.smartphone

class SmartphoneRepository(private val smartphoneDao: SmartphoneDao) {

    suspend fun getAllSmartphones(): List<Smartphone> {
        return smartphoneDao.getAllSmartphones()
    }
}
