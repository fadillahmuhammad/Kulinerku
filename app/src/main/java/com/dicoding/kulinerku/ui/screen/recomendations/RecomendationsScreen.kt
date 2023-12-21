package com.dicoding.kulinerku.ui.screen.recomendations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.kulinerku.R
import com.dicoding.kulinerku.ui.components.Search
import com.dicoding.kulinerku.ui.screen.home.HomeViewModel
import com.dicoding.kulinerku.ui.theme.fontFamily

@Composable
fun RecomendationsScreen(
    modifier: Modifier = Modifier,
    viewModel: RecomendationsViewModel,
    viewModelHome: HomeViewModel
) {
    Column(
        modifier = modifier
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.search_restaurants),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(R.string.sub_title),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        Search(
            query = viewModelHome.querySearch.value,
            onSearch = viewModelHome::search,
            onClear = viewModelHome::clearQuery,
            onSearchAction = {},
            padding = 8
        )
        Spacer(modifier = Modifier.height(16.dp))

    }
}