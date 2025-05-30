package dev.yelinaung.dosetime.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.feature.main.MainScreenState

@Composable
fun MainNavHost(
    mainScreenState: MainScreenState
) {
    val navController = mainScreenState.mainNavController

    NavHost(
        navController = navController,
        startDestination = TabLevelDestination.entries.first().route,
    ) {
        TabLevelDestination.entries.forEach { tab ->
            composable(tab.route) {
                TabLevelNavHost(tab)
            }
        }
    }
}