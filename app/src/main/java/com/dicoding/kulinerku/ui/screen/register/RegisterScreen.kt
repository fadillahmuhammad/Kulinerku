package com.dicoding.kulinerku.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.components.ButtonModel
import com.dicoding.kulinerku.ui.components.TextFieldModel
import com.dicoding.kulinerku.ui.components.TextFieldPasswordModel
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 24.dp),
    ) {
        item {
            Column(
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .clickable { onBackClick() }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.sign_up),
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.sing_up_img),
                    contentDescription = stringResource(R.string.sign_up_image),
                    modifier = Modifier
                        .size(250.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.username),
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                TextFieldModel(
                    modifier = modifier.fillMaxWidth(),
                    label = stringResource(R.string.enter_your_username),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.email),
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                TextFieldModel(
                    modifier = modifier.fillMaxWidth(),
                    label = stringResource(R.string.enter_your_email),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.password),
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                TextFieldPasswordModel(
                    modifier = modifier.fillMaxWidth(),
                    label = stringResource(R.string.enter_your_password),
                )
                Spacer(modifier = Modifier.height(16.dp))
                ButtonModel(
                    text = stringResource(R.string.register),
                    contentDesc = stringResource(R.string.btn_register),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White
                    ),
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = modifier.align(Alignment.End),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.Register_text),
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                    ClickableText(
                        text = AnnotatedString(stringResource(R.string.text_click_login)),
                        modifier = Modifier.clickable {},
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        onClick = { },
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun RegisterScreenPreview() {
    KulinerkuTheme {
        RegisterScreen(onBackClick = {})
    }
}