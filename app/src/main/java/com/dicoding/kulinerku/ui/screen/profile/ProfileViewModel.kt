package com.dicoding.kulinerku.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.kulinerku.data.UserRepository
import com.dicoding.kulinerku.data.local.pref.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {

    private val _userModel = MutableStateFlow<UserModel?>(null)
    val userModel: StateFlow<UserModel?> get() = _userModel

    fun getUserSession() {
        viewModelScope.launch {
            repository.getUserSession()?.let {
                _userModel.value = it
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun clearUserModel() {
        _userModel.value = null
    }
}