package com.dicoding.kulinerku.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")

    object Welcome : Screen("welcome")

    object Home : Screen("home")

    object Login : Screen("login")

    object Register : Screen("register")
}