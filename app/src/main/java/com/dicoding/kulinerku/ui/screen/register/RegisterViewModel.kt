package com.dicoding.kulinerku.ui.screen.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.kulinerku.data.UserRepository
import com.dicoding.kulinerku.data.local.pref.UserModel
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
        firtname: String,
        lastname: String,
        email: String,
        phonenumber: String,
        password: String
    ) =
        repository.registerUser(firtname, lastname, email, phonenumber, password)

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}
