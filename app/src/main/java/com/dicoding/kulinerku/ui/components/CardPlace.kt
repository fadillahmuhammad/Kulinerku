package com.dicoding.kulinerku.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.model.Place
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun CardPlace(
    place: Place,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(160.dp)
            .height(200.dp)
            .shadow(
                elevation = 8.dp,
                clip = true,
                shape = RoundedCornerShape(30.dp),
                ambientColor = Color.Black.copy(alpha = 0.45f)
            )
            .clickable {  },
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Image(
                painter = painterResource(place.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 16.dp
                    ),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = place.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RateModel(
                        modifier = Modifier,
                        rate = place.rate
                    )
                    Image(
                        painter = painterResource(id = R.drawable.favo_fill_ic),
                        contentDescription = "Button Favorites",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun CardPlacePreview() {
    KulinerkuTheme {
        CardPlace(
            place = Place(R.drawable.kiara_place, "Kiara Artha Park", "4.5"),
            modifier = Modifier.padding(8.dp)
        )
    }
}