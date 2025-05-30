package dev.yelinaung.dosetime.feature.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.feature.main.MainScreen
import kotlinx.serialization.Serializable

@Serializable
data object MainRoute

fun NavController.navigateToMain(
    navOptions: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = MainRoute, navOptions)
}

fun NavGraphBuilder.mainScreen() {
    composable<MainRoute> {
        MainScreen()
    }
}