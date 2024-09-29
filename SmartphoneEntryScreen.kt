package com.example.smartphone

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.smartphone.ui.SmartphoneViewModel

@Composable
fun SmartphoneEntryScreen(viewModel: SmartphoneViewModel) {
    var brand by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var storage by remember { mutableStateOf("") }

    Column {
        TextField(value = brand, onValueChange = { brand = it }, label = { Text("Marca") })
        TextField(value = model, onValueChange = { model = it }, label = { Text("Modelo") })
        TextField(value = price, onValueChange = { price = it }, label = { Text("Precio") })
        TextField(value = storage, onValueChange = { storage = it }, label = { Text("Almacenamiento") })
        Button(onClick = {
            viewModel.insertSmartphone(Smartphone(0, brand, model, price.toDouble(), storage.toInt()))
        }) {
            Text("Guardar Smartphone")
        }
    }
}
