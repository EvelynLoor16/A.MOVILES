package com.example.smartphone.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.smartphone.data.SmartphoneViewModel


@Composable
fun SmartphoneListScreen(viewModel: SmartphoneViewModel) {
    val smartphones by viewModel.allSmartphones.observeAsState(initial = emptyList())

    LazyColumn {
        items(smartphones) { smartphone ->
            Text(text = "${smartphone.marca} - ${smartphone.modelo}")
        }
    }
}

