package com.dicoding.kulinerku.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun TextFieldPasswordModel(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    val showPassword = rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = { newText -> onValueChange(newText) },
        label = {
            Text(
                text = label,
                fontSize = 16.sp
            )
        },
        modifier = modifier,
        shape = RoundedCornerShape(30.dp),
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.Black,
            disabledBorderColor = Color.Black,
        ),
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        painter = painterResource(id = R.drawable.visibility),
                        modifier = Modifier.size(24.dp),
                        contentDescription = stringResource(id = R.string.hide_password)
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.visibility_off),
                        modifier = Modifier.size(24.dp),
                        contentDescription = stringResource(id = R.string.show_password)
                    )
                }
            }
        },
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPasswordModelPreview() {
    KulinerkuTheme {
        TextFieldPasswordModel(
            label = "Enter your password",
            value = "",
            onValueChange = {}
        )
    }
}