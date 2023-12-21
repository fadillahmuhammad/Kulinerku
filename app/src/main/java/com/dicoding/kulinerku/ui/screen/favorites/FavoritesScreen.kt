package com.dicoding.kulinerku.ui.screen.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.screen.home.HomeViewModel
import com.dicoding.kulinerku.ui.screen.home.RestaurantColumn
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel,
) {
    val favorites by viewModel.allRestaurants.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadAllRestaurants()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.menu_favorites),
            fontFamily = fontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (favorites.isEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.data_notfound),
                contentDescription = stringResource(R.string.data_notfound),
                modifier = Modifier
                    .size(250.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                itemsIndexed(favorites) { index, restaurant ->
                    key(index) {
                        RestaurantColumn(listOf(restaurant), viewModel, navigateToDetail)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}