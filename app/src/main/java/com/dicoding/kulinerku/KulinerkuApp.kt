package com.dicoding.kulinerku

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.kulinerku.data.local.pref.UserPreference
import com.dicoding.kulinerku.data.local.pref.dataStore
import com.dicoding.kulinerku.di.Injection
import com.dicoding.kulinerku.ui.navigation.Screen
import com.dicoding.kulinerku.ui.screen.login.LoginScreen
import com.dicoding.kulinerku.ui.screen.login.LoginViewModel
import com.dicoding.kulinerku.ui.screen.register.RegisterScreen
import com.dicoding.kulinerku.ui.screen.register.RegisterViewModel
import com.dicoding.kulinerku.ui.screen.splash.SplashScreen
import com.dicoding.kulinerku.ui.screen.welcome.WelcomeScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@Composable
fun KulinerkuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val userRepository = Injection.provideRepository()
    val loginViewModel = LoginViewModel(userRepository)
    val context = LocalContext.current
    val userPreference = remember { UserPreference.getInstance(context.dataStore) }
    var isLoggedIn by remember { mutableStateOf(false) }

    LaunchedEffect(userPreference) {
        val userFlow = userPreference.getSession()
        val user = userFlow.first()
        isLoggedIn = user.isLogin
        delay(2000)
        navigateToNextScreen(navController, isLoggedIn)
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                modifier = Modifier.fillMaxSize(),
                onTimeout = {
                    navigateToNextScreen(navController, isLoggedIn)
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
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                },
                onLoginClick = {
                    navController.navigate(Screen.Main.route)
                },
                viewModel = loginViewModel
            )
        }
        composable(Screen.Register.route) {
            val registerViewModel = RegisterViewModel(userRepository)
            RegisterScreen(
                onBackClick = {
                    navController.navigateUp()
                },
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                },
                viewModel = registerViewModel
            )
        }
    }
}

private fun navigateToNextScreen(navController: NavHostController, isLoggedIn: Boolean) {
    if (isLoggedIn) {
        navController.navigate(Screen.Main.route)
    } else {
        navController.navigate(Screen.Welcome.route)
    }
}