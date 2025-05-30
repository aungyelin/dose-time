package dev.yelinaung.dosetime.feature.history.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.feature.history.HistoryScreen
import kotlinx.serialization.Serializable

@Serializable
data object HistoryRoute

fun NavController.navigateToHistory(navOptions: NavOptions) {
    navigate(route = HistoryRoute, navOptions)
}

fun NavGraphBuilder.historyScreen(
    onClickAddMed: (str: String) -> Unit
) {
    composable<HistoryRoute> {
        HistoryScreen(onClickAddMed)
    }
}
