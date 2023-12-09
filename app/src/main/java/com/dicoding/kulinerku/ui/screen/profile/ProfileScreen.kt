package com.dicoding.kulinerku.ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.components.ButtonModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit,
    viewModel: ProfileViewModel = viewModel()
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Ini Profile Screen")
        ButtonModel(
            text = stringResource(R.string.login),
            contentDesc = stringResource(R.string.btn_login),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ),
            onClick = {
                viewModel.logout()
                onLogoutClick()
            }
        )
    }
}