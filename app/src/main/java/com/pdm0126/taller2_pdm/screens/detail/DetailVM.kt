package com.pdm0126.taller2_pdm.screens.detail

import androidx.lifecycle.ViewModel
import com.pdm0126.taller2_pdm.data.RestaurantRepository
import com.pdm0126.taller2_pdm.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DetailUiState(
    val restaurant: Restaurant? = null,
    val isLoading: Boolean = true
)

class DetailViewModel(
    private val repository: RestaurantRepository,
    restaurantId: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    init {
        loadRestaurant(restaurantId)
    }

    private fun loadRestaurant(id: Int) {
        val restaurant = repository.getRestaurantById(id)
        _uiState.value = DetailUiState(restaurant = restaurant, isLoading = false)
    }
}