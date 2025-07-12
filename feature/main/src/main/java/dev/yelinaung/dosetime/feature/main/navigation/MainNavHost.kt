package dev.yelinaung.dosetime.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.feature.main.MainScreenState
import dev.yelinaung.dosetime.feature.main.rememberTabLevelScreenState

@Composable
fun MainNavHost(
    mainScreenState: MainScreenState,
    tabLevelDestinations: List<TabLevelDestination>,
    modifier: Modifier = Modifier
) {
    val navController = mainScreenState.mainNavController

    NavHost(
        navController = navController,
        startDestination = tabLevelDestinations.first().route,
        modifier = modifier
    ) {
        tabLevelDestinations.forEach { tabLevelDestination ->
            composable(tabLevelDestination.route) {
                val tabLevelScreenState = rememberTabLevelScreenState()
                TabLevelNavHost(tabLevelDestination, tabLevelScreenState)
            }
        }
    }
}