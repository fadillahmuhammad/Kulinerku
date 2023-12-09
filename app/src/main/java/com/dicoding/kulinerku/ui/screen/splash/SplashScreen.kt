package com.dicoding.kulinerku.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.kulinerku.R
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
        delay(3000)
        onTimeout()
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun SplashScreenView() {
    KulinerkuTheme {
        SplashScreen(onTimeout = { })
    }
}
