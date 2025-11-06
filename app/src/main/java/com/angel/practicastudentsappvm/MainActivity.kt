package com.angel.practicastudentsappvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.angel.practicastudentsappvm.presentation.navegation.NavManager
import com.angel.practicastudentsappvm.ui.theme.PracticaStudentsAppVmTheme
import com.angel.practicastudentsappvm.viewmodel.StudentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            PracticaStudentsAppVmTheme {
                NavManager(studentViewModel)
            }
        }
    }
}

