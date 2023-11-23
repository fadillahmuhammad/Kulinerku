package com.dicoding.kulinerku.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    onTextClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionText(title, modifier, onTextClick = onTextClick)
        content()
    }
}

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier,
    onTextClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Text(
            text = stringResource(R.string.see_all),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { onTextClick }
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun SectionTextPreview() {
    KulinerkuTheme {
        SectionText(title = "Tempat Wisata") {

        }
    }
}