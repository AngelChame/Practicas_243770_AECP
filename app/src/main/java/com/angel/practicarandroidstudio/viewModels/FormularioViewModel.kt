package com.angel.practicarandroidstudio.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.angel.practicarandroidstudio.models.Users
import com.angel.practicarandroidstudio.repository.UserRepository
import com.angel.practicarandroidstudio.room.UserDataBase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FormularioViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(application).usersDao()
        repository = UserRepository(userDao)
    }

    // Estados del formulario
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    // Estado de guardado
    private val _isSaving = MutableStateFlow(false)
    val isSaving: StateFlow<Boolean> = _isSaving.asStateFlow()


    val allUsers: StateFlow<List<Users>> = repository.allUSers
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun saveUser() {
        viewModelScope.launch {
            _isSaving.value = true
            try {
                val user = Users(
                    name = _name.value,
                    email = _email.value
                )
                repository.insert(user)

                // Limpiar campos después de guardar
                _name.value = ""
                _email.value = ""
            } finally {
                _isSaving.value = false
            }
        }
    }

    fun deleteUser(user: Users) {
        viewModelScope.launch {
            repository.delete(user)
        }
    }
}