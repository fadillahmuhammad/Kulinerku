package com.dicoding.kulinerku.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun TextFieldNumberModel(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { newText -> onValueChange(newText) },
            label = {
                Text(
                    text = label,
                    fontSize = 16.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            visualTransformation = VisualTransformation.None
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldNumberModelPreview() {
    KulinerkuTheme {
        TextFieldNumberModel(
            label = "Enter your username",
            value = "",
            onValueChange = {}
        )
    }
}