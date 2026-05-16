package com.pdm0126.taller2_pdm.screens.search

import androidx.lifecycle.ViewModel
import com.pdm0126.taller2_pdm.data.RestaurantRepository
import com.pdm0126.taller2_pdm.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SearchUiState(
    val query: String = "",
    val results: List<Restaurant> = emptyList(),
    val hasSearched: Boolean = false
)

class SearchViewModel(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onQueryChange(newQuery: String) {
        val results = repository.searchRestaurants(newQuery)
        _uiState.value = SearchUiState(
            query = newQuery,
            results = results,
            hasSearched = newQuery.isNotBlank()
        )
    }
}