package com.app.examapp.ui.login.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examapp.data.model.User
import com.app.examapp.data.repository.UserRepositoryImpl
import com.app.examapp.domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


data class UserUiState(
    val cargando: Boolean = false,
    val user: User? = null,
    val error: String = ""
)

class LoginViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var uistate by mutableStateOf(UserUiState())
        private set

    var userList by mutableStateOf<List<User>>(emptyList())
        private set

    private val _user = MutableStateFlow<User?>(null)
    val user = _user

    init {
        registerData()
    }

    private fun registerData() {
        viewModelScope.launch {
            val users = repository.getUsers()

            if (users.isEmpty()) {
                repository.addUsers("Sebas", "sebas@gmail.com", "1234")
                repository.addUsers("Gerardo", "gerardo@gmail.com", "1234")
                repository.addUsers("Fernando", "fernando@gmail.com", "1234")
                repository.addUsers("Oliver", "oliver@gmail.com", "1234")
            }

            load()
        }
    }

    fun load() {
        viewModelScope.launch {
            userList = repository.getUsers()
        }
    }

    fun login(email: String, pwd: String) {
        viewModelScope.launch {

            uistate = uistate.copy(cargando = true, error = "")

            try {
                delay(400)
                val result = repository.login(email, pwd)

                if (result != null) {
                    _user.value = result
                    uistate = uistate.copy(
                        cargando = false,
                        user = result,
                        error = ""
                    )
                } else {
                    uistate = uistate.copy(
                        cargando = false,
                        error = "Credenciales incorrectas"
                    )
                }

            } catch (ex: Exception) {
                uistate = uistate.copy(
                    cargando = false,
                    error = "Credenciales incorrectas"
                )
            }
        }
    }

    private fun addUsers(nombre: String, email: String, pwd: String) {
        viewModelScope.launch {
            repository.addUsers(nombre, email, pwd)
            load()
        }
    }
}
