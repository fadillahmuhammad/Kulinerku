package com.dicoding.kulinerku.data.local.pref

data class UserModel(
    val message: String,
    val firstname: String,
    val lastname: String,
    val phonenumber: String,
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)