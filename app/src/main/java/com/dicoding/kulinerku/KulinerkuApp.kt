package com.dicoding.kulinerku

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.kulinerku.ui.navigation.Screen
import com.dicoding.kulinerku.ui.screen.login.LoginScreen
import com.dicoding.kulinerku.ui.screen.register.RegisterScreen
import com.dicoding.kulinerku.ui.screen.splash.SplashScreen
import com.dicoding.kulinerku.ui.screen.welcome.WelcomeScreen

@Composable
fun KulinerkuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                modifier = Modifier.fillMaxSize(),
                onTimeout = {
                    navigateToNextScreen(navController)
                }
            )
        }
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                navigateToRegister = {
                    navController.navigate(Screen.Register.route)
                },
                navigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(Screen.Main.route) {
            MainScreen()
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }
    }
}

private fun navigateToNextScreen(navController: NavHostController) {
    if (isUserLoggedIn()) {
        navController.navigate(Screen.Main.route)
    } else {
        navController.navigate(Screen.Welcome.route)
    }
}

private fun isUserLoggedIn(): Boolean {
    // Token Check (shared preference or another)
    return true
}