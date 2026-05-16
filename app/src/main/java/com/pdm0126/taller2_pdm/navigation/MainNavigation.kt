package com.pdm0126.taller2_pdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.taller2_pdm.data.Repository
import com.pdm0126.taller2_pdm.screens.detail.DetailScreen
import com.pdm0126.taller2_pdm.screens.detail.DetailViewModel
import com.pdm0126.taller2_pdm.screens.home.HomeScreen
import com.pdm0126.taller2_pdm.screens.home.HomeViewModel
import com.pdm0126.taller2_pdm.screens.search.SearchScreen
import com.pdm0126.taller2_pdm.screens.search.SearchViewModel


@Composable
fun MainNavigation() {
    val repository = remember { Repository() }
    val backStack = rememberNavBackStack(Routes.Home())

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {

            entry<Routes.Home> {
                val homeVm: HomeViewModel = viewModel { HomeViewModel(repository) }
                HomeScreen(
                    viewModel = homeVm,
                    onRestaurantClick = { id -> backStack.add(Routes.Detail(id)) },
                    onSearchClick = { backStack.add(Routes.Search()) }
                )
            }

            entry<Routes.Detail> {route ->
                val detailVm: DetailViewModel = viewModel {
                    DetailViewModel(repository, route.restaurantId)
                }
                DetailScreen(
                    viewModel = detailVm,
                    onBack = { backStack.removeLastOrNull() }
                )
            }

            entry<Routes.Search> {
                val searchVm: SearchViewModel = viewModel { SearchViewModel(repository) }
                SearchScreen(
                    viewModel = searchVm,
                    onBack = { backStack.removeLastOrNull() },
                    onRestaurantClick = { id -> backStack.add(Routes.Detail(id)) }
                )
            }
        }
    )
}
