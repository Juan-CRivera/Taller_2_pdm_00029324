package com.pdm0126.taller2_pdm.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    object Home : Routes()

    @Serializable
    data class Detail() : Routes()

    @Serializable
    object Search : Routes()
}