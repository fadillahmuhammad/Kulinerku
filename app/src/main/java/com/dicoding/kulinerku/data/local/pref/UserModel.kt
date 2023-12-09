package com.dicoding.kulinerku.data.local.pref

data class UserModel(
    val message: String,
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)