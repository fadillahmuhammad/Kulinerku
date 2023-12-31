package com.dicoding.kulinerku.ui.navigation

sealed class Screen(val route: String) {
    object Initial : Screen("initial")
    object Splash : Screen("splash")
    object Welcome : Screen("welcome")
    object Main : Screen("main")
    object Home : Screen("home")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")
    object Login : Screen("login")
    object Register : Screen("register")
    object About : Screen("about")
    object Detail : Screen("home/{restaurantId}") {
        fun createRoute(restaurantId: Int) = "home/$restaurantId"
    }
    object Recomendations : Screen("recomendations")
}