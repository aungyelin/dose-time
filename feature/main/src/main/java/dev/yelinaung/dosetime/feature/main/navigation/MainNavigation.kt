package dev.yelinaung.dosetime.feature.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.feature.main.MainScreen
import kotlinx.serialization.Serializable

@Serializable
data object MainRoute

fun NavController.navigateToMain(
    navOptions: NavOptionsBuilder.() -> Unit = {
        popUpTo(graph.findStartDestination().id) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = false
    }
) {
    navigate(route = MainRoute, navOptions)
}

fun NavGraphBuilder.mainScreen() {
    composable<MainRoute> {
        MainScreen()
    }
}