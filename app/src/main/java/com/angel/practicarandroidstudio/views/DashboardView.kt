package com.angel.practicarandroidstudio.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Dashboard(navController: NavController){

    Scaffold (
        topBar = {
            DashboardTopBar()
        }
    ){paddingValues ->

        Column (
            modifier =  Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "Hola desde la dashboard",
            )
            Content(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardTopBar() {
    CenterAlignedTopAppBar(
        title = { Text("Dashboard") }
    )
}


@Composable
private fun Content(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Button(onClick = {
            navController.navigate("ChangeThemeView")
        }) {
            Text("Cambiar tema")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate("FormsView")
        }) { Text("Form (DataStore)")}

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate("FormularioView")
        }) { Text("Formulario (Room)")}

        Spacer(modifier = Modifier.height(10.dp))


    }
}