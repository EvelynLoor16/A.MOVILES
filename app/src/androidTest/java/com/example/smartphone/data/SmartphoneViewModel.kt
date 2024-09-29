package com.example.smartphone.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SmartphoneViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SmartphoneRepository
    val allSmartphones: LiveData<List<Smartphone>>

    init {
        val smartphoneDao = SmartphoneDatabase.getDatabase(application).smartphoneDao()
        repository = SmartphoneRepository(smartphoneDao)
        allSmartphones = repository.allSmartphones
    }

    fun insert(smartphone: Smartphone) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(smartphone)
    }

    operator fun invoke(): SmartphoneViewModel {

        return TODO("Provide the return value")
    }
}

