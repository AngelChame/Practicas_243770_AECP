package com.angel.practicacoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.angel.practicacoroutines.presentation.navegation.NavManager
import com.angel.practicacoroutines.presentation.viewmodel.CoroutinesViewModel
import com.angel.practicacoroutines.ui.theme.PracticaCoroutinesTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CoroutinesViewModel by viewModels()
            PracticaCoroutinesTheme {
                NavManager(viewModel)
            }
        }
    }
}

