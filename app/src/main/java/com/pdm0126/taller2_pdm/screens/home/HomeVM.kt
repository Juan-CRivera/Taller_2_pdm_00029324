package com.pdm0126.taller2_pdm.screens.home

import androidx.lifecycle.ViewModel
import com.pdm0126.taller2_pdm.data.RestaurantRepository
import com.pdm0126.taller2_pdm.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val categorizedRestaurants: Map<String, List<Restaurant>> = emptyMap()
)

class HomeViewModel(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        val allRestaurants = repository.getAllRestaurants()

        val grouped = mutableMapOf<String, MutableList<Restaurant>>()
        allRestaurants.forEach { restaurant ->
            restaurant.categories.forEach { category ->
                grouped.getOrPut(category) { mutableListOf() }.add(restaurant)
            }
        }

        _uiState.value = HomeUiState(categorizedRestaurants = grouped)
    }
}