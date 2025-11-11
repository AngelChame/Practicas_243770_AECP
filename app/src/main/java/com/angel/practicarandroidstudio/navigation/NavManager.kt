package com.angel.practicarandroidstudio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.angel.practicarandroidstudio.views.Dashboard
import com.angel.practicarandroidstudio.views.ChangeThemeView
import com.angel.practicarandroidstudio.views.FormsView
import com.angel.practicarandroidstudio.views.FormularioView
import com.angel.practicarandroidstudio.views.UsersListView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Dashboard"){

        composable ("Dashboard"){
        Dashboard(navController)
        }
        composable ("ChangeThemeView"){
            ChangeThemeView(navController)
        }
        composable ("FormsView"){
            FormsView(navController)
        }
        composable   ("FormularioView"){
            FormularioView(navController)
        }
        composable("UsersListView") {
            UsersListView(navController)
        }
    }
}