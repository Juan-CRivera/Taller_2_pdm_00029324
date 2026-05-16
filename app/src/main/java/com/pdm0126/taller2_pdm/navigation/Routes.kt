package com.pdm0126.taller2_pdm.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes : NavKey {
    @Serializable
    data class Home(val id: String = "home") : Routes()

    @Serializable
    data class Detail(val restaurantId: Int) : Routes()

    @Serializable
    data class Search(val id: String = "search") : Routes()
}
