package com.example.smartphone.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartphone.data.Smartphone
import com.example.smartphone.data.SmartphoneViewModel

@Composable
fun SmartphoneInputScreen(viewModel: SmartphoneViewModel = viewModel()) {
    // Variables para los campos
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var almacenamiento by remember { mutableStateOf("") }
    var sistemaOperativo by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Composición de la interfaz
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título y subtítulos
        Text(
            text = "LOOR MERO EVELYN NALLELY",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "MI ENTIDAD ASIGNADA ES SMARTPHONE",
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "NIVEL SEPTIMO B",
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campos de entrada
        OutlinedTextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = almacenamiento,
            onValueChange = { almacenamiento = it },
            label = { Text("Almacenamiento") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = sistemaOperativo,
            onValueChange = { sistemaOperativo = it },
            label = { Text("Sistema Operativo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Mostrar mensaje de error si existe
        errorMessage?.let { message ->
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error, // Cambiado a Material 3
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar
        Button(
            onClick = {
                // Validación de campos numéricos
                val precioValido = precio.toDoubleOrNull()
                val almacenamientoValido = almacenamiento.toIntOrNull()

                // Validación de campos
                when {
                    marca.isBlank() || modelo.isBlank() || sistemaOperativo.isBlank() -> {
                        errorMessage = "Por favor, completa todos los campos."
                    }
                    precioValido == null || almacenamientoValido == null -> {
                        errorMessage = "Los valores de Precio y Almacenamiento deben ser numéricos."
                    }
                    else -> {
                        // Crear el objeto Smartphone y guardarlo
                        val smartphone = Smartphone(
                            marca = marca,
                            modelo = modelo,
                            precio = precioValido,
                            almacenamiento = almacenamientoValido,
                            sistemaOperativo = sistemaOperativo
                        )
                        viewModel.insert(smartphone)

                        // Limpiar los campos después de guardar
                        marca = ""
                        modelo = ""
                        precio = ""
                        almacenamiento = ""
                        sistemaOperativo = ""
                        errorMessage = null  // Limpiar el mensaje de error
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
        ) {
            Text("Guardar")
        }
    }
}
