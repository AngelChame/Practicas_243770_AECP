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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.angel.practicarandroidstudio.viewModels.FormularioViewModel

@Composable
fun FormularioView(
    navController: NavController,
    viewModel: FormularioViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            FormularioTopBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hola, rellena este form")
            FormContent(viewModel, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormularioTopBar(navController: NavController) {
    CenterAlignedTopAppBar(
        navigationIcon = {
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
private fun FormContent(viewModel: FormularioViewModel, navController: NavController) {
    // Observar estados del ViewModel
    val name by viewModel.name.collectAsState()
    val email by viewModel.email.collectAsState()
    val isSaving by viewModel.isSaving.collectAsState()
    //val lastUser by viewModel.lastUser.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = name,
            onValueChange = viewModel::onNameChange,
            label = { Text("Nombre") },
            placeholder = { Text("Angel Chame") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            enabled = !isSaving
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = viewModel::onEmailChange,
            label = { Text("Email") },
            placeholder = { Text("ejemplo@gmail.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            enabled = !isSaving
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = viewModel::saveUser,
            enabled = !isSaving && name.isNotBlank() && email.isNotBlank()
        ) {
            if (isSaving) {
                CircularProgressIndicator(
                    modifier = Modifier.height(20.dp)
                )
            } else {
                Text("Guardar usuario")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("UsersListView")
        }) {
            Text("Ver usuarios guardados")
        }

        /*Mostrar último usuario guardado
        Text("Último usuario guardado:")
        Spacer(modifier = Modifier.height(8.dp))
        lastUser?.let { user ->
            Text("ID: ${user.id}")
            Text("Nombre: ${user.name}")
            Text("Email: ${user.email}")
        } ?: Text("No hay datos guardados")*/
    }
}