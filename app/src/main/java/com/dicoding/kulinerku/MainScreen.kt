package com.dicoding.kulinerku

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dicoding.kulinerku.di.Injection
import com.dicoding.kulinerku.model.dummyRestaurant
import com.dicoding.kulinerku.ui.ViewModelFactory
import com.dicoding.kulinerku.ui.navigation.NavigationItem
import com.dicoding.kulinerku.ui.navigation.Screen
import com.dicoding.kulinerku.ui.screen.about.AboutScreen
import com.dicoding.kulinerku.ui.screen.detail.DetailScreen
import com.dicoding.kulinerku.ui.screen.detail.DetailViewModel
import com.dicoding.kulinerku.ui.screen.favorites.FavoritesScreen
import com.dicoding.kulinerku.ui.screen.home.HomeScreen
import com.dicoding.kulinerku.ui.screen.home.HomeViewModel
import com.dicoding.kulinerku.ui.screen.profile.ProfileScreen
import com.dicoding.kulinerku.ui.screen.profile.ProfileViewModel
import com.dicoding.kulinerku.ui.screen.recomendations.RecomendationsScreen
import com.dicoding.kulinerku.ui.screen.recomendations.RecomendationsViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val userRepository = Injection.provideRepository()
    val profileViewModel = viewModel<ProfileViewModel>(
        factory = ViewModelFactory(userRepository)
    )
    val homeViewModel = viewModel<HomeViewModel>(
        factory = ViewModelFactory(userRepository)
    )
    val detailViewModel = viewModel<DetailViewModel>(
        factory = ViewModelFactory(userRepository)
    )
    val recomendationsViewModel = viewModel<RecomendationsViewModel>(
        factory = ViewModelFactory(userRepository)
    )

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Initial.route && currentRoute != Screen.About.route && currentRoute != Screen.Detail.route && currentRoute != Screen.Recomendations.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    viewModel = homeViewModel,
                    navigateToDetail = { rewardId ->
                        navController.navigate(Screen.Detail.createRoute(rewardId))
                    },
                    navigateToRecomendationsScreen = {
                        navController.navigate(Screen.Recomendations.route)
                    }
                )
            }
            composable(Screen.Favorites.route) {
                FavoritesScreen(
                    viewModel = homeViewModel,
                    navigateToDetail = { restaurantId ->
                        navController.navigate(Screen.Detail.createRoute(restaurantId))
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("restaurantId") { type = NavType.IntType }),
            ) {
                val id = it.arguments?.getInt("restaurantId") ?: -1
                DetailScreen(
                    restaurantId = id,
                    viewModel = detailViewModel,
                    onBackClick = {
                        navController.navigateUp()
                    },
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    onLogoutClick = {
                        navController.navigate(Screen.Initial.route)
                    },
                    onAboutClick = {
                        navController.navigate(Screen.About.route)
                    },
                    viewModel = profileViewModel,
                )
            }
            composable(Screen.Initial.route) {
                KulinerkuApp()
            }
            composable(Screen.About.route) {
                AboutScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }
            composable(Screen.Recomendations.route) {
                RecomendationsScreen(
                    viewModelHome = homeViewModel,
                    viewModel = recomendationsViewModel,
                    listRestaurant = dummyRestaurant,
                    navigateToDetail = { restaurantId ->
                        navController.navigate(Screen.Detail.createRoute(restaurantId))
                    },
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_favorites),
                icon = Icons.Default.Favorite,
                screen = Screen.Favorites
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.outline,
                    unselectedTextColor = MaterialTheme.colorScheme.outline,
                )
            )
        }
    }
}