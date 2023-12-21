package com.dicoding.kulinerku.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.data.local.entity.RestaurantEntity
import com.dicoding.kulinerku.model.Restaurant
import com.dicoding.kulinerku.ui.screen.home.HomeViewModel
import com.dicoding.kulinerku.ui.theme.fontFamily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CardRestaurant(
    restaurant: Restaurant,
    viewModel: HomeViewModel,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var isFavoriteState by remember { mutableStateOf(false) }

    val coroutineScope = CoroutineScope(Dispatchers.Default)

    LaunchedEffect(restaurant) {
        val restaurantEntity = viewModel.getRestaurantByName(restaurant.name)
        if (restaurantEntity != null) {
            isFavoriteState = viewModel.isFavorite(restaurantEntity)
        }
    }

    Card(
        modifier = modifier
            .width(358.dp)
            .height(304.dp)
            .shadow(
                elevation = 8.dp,
                clip = true,
                shape = RoundedCornerShape(30.dp),
                ambientColor = Color.Black.copy(alpha = 0.35f)
            )
            .clickable {
                navigateToDetail(restaurant.id)
            },
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(restaurant.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(158.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RateModel(
                        rate = restaurant.rate,
                    )
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
                            .size(34.dp)
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
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = restaurant.name,
                fontFamily = fontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.money_ic),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = restaurant.price,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.loc_ic),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = restaurant.address,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(
                        bottom = 12.dp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp
                )
            }
        }
    }
}

fun Restaurant.toEntity(): RestaurantEntity {
    return RestaurantEntity(
        id = this.id,
        image = this.image,
        name = this.name,
        rate = this.rate,
        address = this.address,
        price = this.price,
        street = this.street,
        region = this.region,
        subdistrict = this.subdistrict
    )
}
