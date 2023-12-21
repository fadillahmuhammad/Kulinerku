package com.dicoding.kulinerku.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.kulinerku.data.UserRepository
import com.dicoding.kulinerku.data.local.entity.RestaurantEntity
import com.dicoding.kulinerku.model.Restaurant
import com.dicoding.kulinerku.ui.common.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: UserRepository) : ViewModel() {
    private val _resultState: MutableStateFlow<ResultState<Restaurant>> =
        MutableStateFlow(ResultState.Loading)
    val resultState: StateFlow<ResultState<Restaurant>>
        get() = _resultState

    fun getRestaurantById(restaurantId: Int) {
        viewModelScope.launch {
            _resultState.value = ResultState.Loading
            _resultState.value = ResultState.Success(repository.getRestaurantById(restaurantId))
        }
    }

    suspend fun insertFavorite(restaurant: RestaurantEntity) {
        repository.insertFavorite(restaurant)
    }

    suspend fun deleteFavorite(restaurant: RestaurantEntity) {
        repository.deleteFavorite(restaurant)
    }

    suspend fun isFavorite(restaurant: RestaurantEntity): Boolean {
        return repository.isFavorite(restaurant)
    }

    suspend fun getRestaurantByName(name: String): RestaurantEntity {
        return repository.getRestaurantByName(name)
    }
}