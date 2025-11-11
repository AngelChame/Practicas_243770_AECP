package com.angel.practicarandroidstudio.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.angel.practicarandroidstudio.DataStore.StoreDarkMode
import kotlinx.coroutines.launch

@Composable
fun ChangeThemeView(navController: NavController){

    val context = LocalContext.current
    val darkModeStore = StoreDarkMode(context)
    val darkMode by darkModeStore.getDarkMode.collectAsState(initial = false)

    Scaffold (
        topBar = {
            ChangeThemeTopBar(navController)
        }
    ){paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Hola, estas por cambiar el tema")
            ContentChangeTheme(darkModeStore, darkMode)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChangeThemeTopBar(navController: NavController){
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
            Text("Cambiar tema")
        }
    )
}

@Composable
private fun ContentChangeTheme (storeDarkMode: StoreDarkMode, darkMode: Boolean){
    val scope = rememberCoroutineScope()
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text("Cambiar a dark")

        Switch(checked = darkMode, onCheckedChange = { isChecked ->
            scope.launch {
                storeDarkMode.saveDarkMode(isChecked)
            }

        })
    }
}
