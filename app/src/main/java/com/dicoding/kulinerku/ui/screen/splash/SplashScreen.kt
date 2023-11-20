package com.dicoding.kulinerku.ui.screen.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.screen.login.LoginScreen
import com.dicoding.kulinerku.ui.screen.login.RegisterScreen
import com.dicoding.kulinerku.ui.screen.welcome.WelcomeScreen
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onTimeout: () -> Unit
) {
    Image(
        painter = painterResource(id = R.drawable.logo_app),
        contentDescription = null,
        modifier = modifier
    )

    LaunchedEffect(true) {
        delay(2000)
        onTimeout()
    }
}

@Composable
fun MyAppWithSplash() {
    var showTimeOutScreen by remember { mutableStateOf(false) }

    if (showTimeOutScreen) {
        LoginScreen(onBackClick = {})
    } else {
        SplashScreen(
            modifier = Modifier.fillMaxSize(),
            onTimeout = {
                Log.d("MyApp", "onTimeout called")
                showTimeOutScreen = true
            }
        )
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun SplashScreenView() {
    KulinerkuTheme {
        SplashScreen(onTimeout = { })
    }
}
