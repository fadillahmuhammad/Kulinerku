package com.dicoding.kulinerku.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.model.Place
import com.dicoding.kulinerku.model.dummyPlace
import com.dicoding.kulinerku.ui.components.CardPlace
import com.dicoding.kulinerku.ui.components.HomeSection
import com.dicoding.kulinerku.ui.components.Search
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Banner()
            Spacer(modifier = Modifier.height(16.dp))
            HomeSection(
                title = stringResource(R.string.section_popular_place),
                content = { PlaceRow(dummyPlace) },
                onTextClick = {}
            )
            Spacer(modifier = Modifier.height(28.dp))
            HomeSection(
                title = stringResource(R.string.section_restaurant_recomendation),
                content = {},
                onTextClick = {}
            )
        }
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 30.dp,
                    bottomEnd = 30.dp
                )
            )
    ) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = stringResource(R.string.banner_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(147.dp)
        )
        Search()
    }
}

@Composable
fun PlaceRow(
    listPlace: List<Place>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listPlace, key = { it.name }) { place ->
            CardPlace(place)
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun HomeScreenPreview() {
    KulinerkuTheme {
        HomeScreen()
    }
}