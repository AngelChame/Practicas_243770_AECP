package com.angel.practicacoroutines.presentation.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.angel.practicacoroutines.presentation.viewmodel.CoroutinesViewModel
import com.angel.practicacoroutines.presentation.views.ButtonsView
import com.angel.practicacoroutines.presentation.views.DashboardView

@Composable
fun NavManager(viewModel: CoroutinesViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "DashboardView"
    ){
        composable(
            "DashboardView"
        ){
            DashboardView(navController)
        }

        composable(
            "ButtonsView"
        ){
            ButtonsView(navController, viewModel)
        }

    }
}