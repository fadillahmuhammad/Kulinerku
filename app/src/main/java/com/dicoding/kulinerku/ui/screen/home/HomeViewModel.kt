package com.dicoding.kulinerku.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.kulinerku.data.UserRepository
import com.dicoding.kulinerku.data.local.entity.RestaurantEntity
import com.dicoding.kulinerku.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: UserRepository) : ViewModel() {

    private val _allRestaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val allRestaurants: StateFlow<List<Restaurant>> get() = _allRestaurants

    private val _querySearch = mutableStateOf("")
    val querySearch: State<String> get() = _querySearch

    init {
        viewModelScope.launch {
            _allRestaurants.value = repository.getAllFavorites().toRestaurantList()
        }
    }

    fun search(newQuery: String) {
        _querySearch.value = newQuery
    }

    fun clearQuery() {
        viewModelScope.launch {
            _querySearch.value = ""
        }
    }

    fun loadAllRestaurants() {
        viewModelScope.launch {
            _allRestaurants.value = repository.getAllFavorites().toRestaurantList()
        }
    }

    private fun List<RestaurantEntity>.toRestaurantList(): List<Restaurant> {
        return map { restaurantEntity ->
            Restaurant(
                id = restaurantEntity.id,
                image = restaurantEntity.image,
                name = restaurantEntity.name,
                rate = restaurantEntity.rate,
                distance = restaurantEntity.distance,
                address = restaurantEntity.address,
                price = restaurantEntity.price
            )
        }
    }

    fun insertFavorite(restaurant: RestaurantEntity) {
        viewModelScope.launch {
            repository.insertFavorite(restaurant)
        }
    }

    fun deleteFavorite(restaurant: RestaurantEntity) {
        viewModelScope.launch {
            repository.deleteFavorite(restaurant)
        }
    }

    suspend fun getRestaurantByName(name: String): RestaurantEntity {
        return repository.getRestaurantByName(name)
    }

    suspend fun isFavorite(restaurant: RestaurantEntity): Boolean {
        return repository.isFavorite(restaurant)
    }
}
