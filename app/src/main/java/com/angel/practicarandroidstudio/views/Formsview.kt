package com.angel.practicarandroidstudio.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angel.practicarandroidstudio.DataStore.StoreUserProfile
import kotlinx.coroutines.launch

@Composable
fun FormsView(navController: NavController){



    Scaffold (
        topBar = {
            FormTopBar(navController)
        }
    ){paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Hola, rellena este form")
            FormContent()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormTopBar(navController: NavController){
    CenterAlignedTopAppBar(
        navigationIcon   = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Atras"
                )
            }
        },
        title = {
            Text("Formulario")
        }
    )
}

@Composable
private fun FormContent(){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreUserProfile(context)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        var email by rememberSaveable { mutableStateOf("") }
        var name by rememberSaveable { mutableStateOf("") }
        var phone by rememberSaveable { mutableStateOf("") }
        var age by rememberSaveable { mutableStateOf("") }
        val userEmail = dataStore.getEmail.collectAsState(initial = "")
        val userName = dataStore.getName.collectAsState(initial = "")
        val userPhone = dataStore.getPhone.collectAsState(initial = "")
        val userAge = dataStore.getAge.collectAsState(initial = "")

        TextField(
            value = email,
            onValueChange = { email = it },
            label = {Text("Email")},
            placeholder = { Text("ejemplo@gmail.com") },
            keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Email)
            )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = {Text("Name")},
            placeholder = { Text("ej.Angel Chame") },
            keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = {Text("Phonr number")},
            placeholder = { Text("ej.961215151") },
            keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = age,
            onValueChange = { age = it },
            label = {Text("Age")},
            placeholder = { Text("ej.19") },
            keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                dataStore.saveUserProfile(email,name,phone, age)
            }
        }) {
            Text("Guardar datos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Datos guardados")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Email: ${userEmail.value}")
        Text("Nombre: ${userName.value}")
        Text("Teléfono: ${userPhone.value}")
        Text("Edad: ${userAge.value}")
    }
}