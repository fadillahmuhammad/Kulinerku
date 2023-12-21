package com.dicoding.kulinerku.ui.screen.home

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.di.Injection
import com.dicoding.kulinerku.model.Restaurant
import com.dicoding.kulinerku.model.dummyRestaurant
import com.dicoding.kulinerku.ui.components.CardRestaurant
import com.dicoding.kulinerku.ui.components.HomeSection
import com.dicoding.kulinerku.ui.components.Search
import com.dicoding.kulinerku.ui.theme.KulinerkuTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    navigateToRecomendationsScreen: () -> Unit,
    viewModel: HomeViewModel
) {
    val context = LocalContext.current
    BackHandler {
        context.findActivity()?.finish()
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            Banner(
                viewModel = viewModel,
                onSearchAction = navigateToRecomendationsScreen
            )
            Spacer(modifier = Modifier.height(16.dp))
//            HomeSection(
//                title = stringResource(R.string.section_popular_place),
//                content = { PlaceRow(dummyPlace) },
//                onTextClick = {}
//            )
//            Spacer(modifier = Modifier.height(28.dp))
            HomeSection(
                title = stringResource(R.string.section_restaurant_recomendation),
                content = { RestaurantColumn(dummyRestaurant, viewModel, navigateToDetail) },
                onTextClick = { navigateToRecomendationsScreen() }
            )
        }
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    onSearchAction: () -> Unit
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
        Search(
            query = viewModel.querySearch.value,
            onSearch = viewModel::search,
            onClear = viewModel::clearQuery,
            onSearchAction = onSearchAction,
            padding = 16
        )
    }
}

//@Composable
//fun PlaceRow(
//    listPlace: List<Place>,
//    modifier: Modifier = Modifier
//) {
//    LazyRow(
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        modifier = modifier
//    ) {
//        items(listPlace, key = { it.name }) { place ->
//            CardPlace(place)
//        }
//    }
//}

@Composable
fun RestaurantColumn(
    listRestaurant: List<Restaurant>,
    viewModel: HomeViewModel,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        listRestaurant.forEach { restaurant ->
            CardRestaurant(restaurant, viewModel, navigateToDetail)
        }
    }
}

fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun HomeScreenPreview() {
    KulinerkuTheme {
        val userRepository = Injection.provideRepository()
        HomeScreen(
            viewModel = HomeViewModel(userRepository),
            navigateToDetail = {},
            navigateToRecomendationsScreen = {})
    }
}