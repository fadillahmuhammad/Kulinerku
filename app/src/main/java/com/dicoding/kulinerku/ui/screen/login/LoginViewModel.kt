package com.dicoding.kulinerku.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.kulinerku.data.UserRepository
import com.dicoding.kulinerku.data.local.pref.UserModel
import com.dicoding.kulinerku.ui.common.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _loginResult = MutableStateFlow<ResultState<UserModel>>(ResultState.Loading)
    val loginResult: StateFlow<ResultState<UserModel>> = _loginResult

    fun loginUser(
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            try {
                val result = repository.loginUser(email, password)
                _loginResult.value = result
            } catch (e: Exception) {
                _loginResult.value = ResultState.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}