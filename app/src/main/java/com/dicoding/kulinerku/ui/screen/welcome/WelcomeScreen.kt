package com.dicoding.kulinerku.ui.screen.welcome

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.components.ButtonModel
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit,
) {
    val context = LocalContext.current
    BackHandler {
        context.findActivity()?.finish()
    }

    Column(
        modifier = modifier.padding(vertical = 40.dp, horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.welcome_title),
            fontFamily = fontFamily,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.welcome_description),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(44.dp))
        ButtonModel(
            text = stringResource(R.string.login),
            contentDesc = stringResource(R.string.button_login),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorScheme.primary,
                contentColor = Color.White
            ),
            onClick = { navigateToLogin() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ButtonModel(
            text = stringResource(R.string.register),
            contentDesc = stringResource(R.string.button_register),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorScheme.primaryContainer,
                contentColor = colorScheme.primary
            ),
            onClick = { navigateToRegister() }
        )
    }
}

fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    KulinerkuTheme {
        WelcomeScreen(
            navigateToLogin = {},
            navigateToRegister = {},
        )
    }
}
