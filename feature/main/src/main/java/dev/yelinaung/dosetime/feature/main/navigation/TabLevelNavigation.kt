package dev.yelinaung.dosetime.feature.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HomeTabRoute

fun NavController.navigateToHomeTab(navOptions: NavOptions) {
    navigate(route = HomeTabRoute, navOptions)
}

@Serializable
data object HistoryTabRoute

fun NavController.navigateToHistoryTab(navOptions: NavOptions) {
    navigate(route = HistoryTabRoute, navOptions)
}