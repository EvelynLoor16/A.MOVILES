package com.example.smartphone

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import com.example.smartphone.ui.SmartphoneViewModel

@Composable
fun SmartphoneListScreen(viewModel: SmartphoneViewModel) {
    // Observa el LiveData desde el ViewModel
    val smartphones by viewModel.smartphoneList.observeAsState(listOf())

    // Mostrar la lista de smartphones en la pantalla usando LazyColumn
    LazyColumn {
        items(smartphones) { smartphone ->
            Text(text = "${smartphone.brand} - ${smartphone.model} - \$${smartphone.price}")
        }
    }
}

