package com.dicoding.kulinerku.ui.screen.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.kulinerku.data.UserRepository
import com.dicoding.kulinerku.data.local.pref.RegisterModel
import com.dicoding.kulinerku.ui.common.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: UserRepository) : ViewModel() {
    private val _firstname = mutableStateOf("")
    val firtname: State<String> = _firstname

    private val _lastname = mutableStateOf("")
    val lastname: State<String> = _lastname

    private val _phonenumber = mutableStateOf("")
    val phonenumber: State<String> = _phonenumber

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _registerResult = MutableStateFlow<ResultState<RegisterModel>>(ResultState.Loading)
    val registerResult: StateFlow<ResultState<RegisterModel>> = _registerResult

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setFirstname(firstname: String) {
        _firstname.value = firstname
    }

    fun setLastname(lastname: String) {
        _lastname.value = lastname
    }

    fun setPhonenumber(phonenumber: String) {
        _phonenumber.value = phonenumber
    }

    fun registerUser(
        firstname: String,
        lastname: String,
        phonenumber: String,
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            try {
                val result =
                    repository.registerUser(firstname, lastname, phonenumber, email, password)
                _registerResult.value = result
            } catch (e: Exception) {
                _registerResult.value = ResultState.Error(e.message ?: "An error occurred")
            }
        }
    }
}
