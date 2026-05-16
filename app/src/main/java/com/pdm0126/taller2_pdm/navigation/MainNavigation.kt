package com.pdm0126.taller2_pdm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.taller2_pdm.screens.detail.DetailScreen
import com.pdm0126.taller2_pdm.screens.home.HomeScreen
import com.pdm0126.taller2_pdm.screens.search.SearchScreen


@Composable
fun MainNavigation() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {

            entry<Routes.Home> {
                HomeScreen()
            }

            entry<Routes.Detail> {
                DetailScreen()
            }

            entry<Routes.Search> {
                SearchScreen()
            }
        }
    )
}

