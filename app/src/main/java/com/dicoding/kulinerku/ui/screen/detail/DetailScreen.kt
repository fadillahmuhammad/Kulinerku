package com.dicoding.kulinerku.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.model.Restaurant
import com.dicoding.kulinerku.ui.common.ResultState
import com.dicoding.kulinerku.ui.components.toEntity
import com.dicoding.kulinerku.ui.theme.fontFamily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(
    restaurantId: Int,
    viewModel: DetailViewModel,
    onBackClick: () -> Unit,
) {
    LaunchedEffect(restaurantId) {
        viewModel.getRestaurantById(restaurantId)
    }

    viewModel.resultState.collectAsState(initial = ResultState.Loading).value.let { resultState ->
        when (resultState) {
            is ResultState.Loading -> {
                viewModel.getRestaurantById(restaurantId)
            }

            is ResultState.Success -> {
                val data = resultState.data
                DetailContent(
                    data.image,
                    data.name,
                    data.rate,
                    data.distance,
                    data.address,
                    data.price,
                    onBackClick = onBackClick,
                    viewModel = viewModel,
                    restaurant = data
                )
            }

            is ResultState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    name: String,
    rate: String,
    distance: String,
    address: String,
    price: String,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel,
    restaurant: Restaurant,
    modifier: Modifier = Modifier
) {
    var isFavoriteState by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val restaurantEntity = viewModel.getRestaurantByName(restaurant.name)
        isFavoriteState = viewModel.isFavorite(restaurantEntity)
    }

    val coroutineScope = CoroutineScope(Dispatchers.Default)
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .clickable { onBackClick() }
            )
            Spacer(modifier = Modifier.width(42.dp))
            Text(
                text = stringResource(R.string.detail_title),
                fontFamily = fontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
        Card(
            modifier = modifier
                .width(358.dp)
                .padding(horizontal = 16.dp)
                .height(215.dp)
                .shadow(
                    elevation = 8.dp,
                    clip = true,
                    shape = RoundedCornerShape(30.dp),
                    ambientColor = Color.Black.copy(alpha = 0.35f)
                ),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            )
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = name,
                fontFamily = fontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(4f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(
                    id = if (isFavoriteState) {
                        R.drawable.favo_fill_ic
                    } else {
                        R.drawable.favo_outline_ic
                    }
                ),
                contentDescription = stringResource(R.string.button_favorites),
                modifier = Modifier
                    .size(44.dp)
                    .weight(1f)
                    .clickable {
                        coroutineScope.launch {
                            try {
                                if (isFavoriteState) {
                                    viewModel.deleteFavorite(restaurant.toEntity())
                                } else {
                                    viewModel.insertFavorite(restaurant.toEntity())
                                }
                                isFavoriteState = !isFavoriteState
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = modifier.fillMaxWidth(),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                )
            }
        ) {
            Tab(
                text = { Text(
                    text = stringResource(R.string.reviews_tab),
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                ) },
                selected = selectedTabIndex == 0,
                onClick = {
                    selectedTabIndex = 0
                }
            )
            Tab(
                text = { Text(
                    text = stringResource(R.string.about_tab),
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                ) },
                selected = selectedTabIndex == 1,
                onClick = {
                    selectedTabIndex = 1
                }
            )
        }
        when (selectedTabIndex) {
            0 -> {
                LazyColumn(
                    modifier = Modifier,
                    contentPadding = PaddingValues(bottom = 26.dp)
                ){
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.profile_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "Rekomendasi banget! tempatnya nyaman.")
                        }
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.profile_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "Enak buat belajar! recomended.")
                        }
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))
                    }
                }
            }
            1 -> {
                LazyColumn(
                    modifier = Modifier,
                    contentPadding = PaddingValues(bottom = 26.dp)
                ){
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.money_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = price)
                        }
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.star_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = rate)
                        }
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.loc_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = address)
                        }
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))
                    }
                }
            }
        }
    }
}