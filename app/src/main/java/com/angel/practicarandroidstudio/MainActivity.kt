package com.angel.practicarandroidstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import com.angel.practicarandroidstudio.ui.theme.PracticarAndroidStudioTheme
import com.angel.practicarandroidstudio.DataStore.StoreDarkMode
import com.angel.practicarandroidstudio.navigation.NavManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkModeStore = StoreDarkMode(this)
            val darkMode = darkModeStore.getDarkMode.collectAsState(initial = false)
            PracticarAndroidStudioTheme (darkTheme = darkMode.value){
                NavManager()
            }
        }
    }
}

