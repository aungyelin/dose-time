package dev.yelinaung.dosetime.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.yelinaung.dosetime.feature.addmed.navigation.addMedScreen
import dev.yelinaung.dosetime.feature.addmed.navigation.navigateToAddMed
import dev.yelinaung.dosetime.feature.history.navigation.HistoryRoute
import dev.yelinaung.dosetime.feature.history.navigation.historyScreen
import dev.yelinaung.dosetime.feature.home.navigation.HomeRoute
import dev.yelinaung.dosetime.feature.home.navigation.homeScreen

@Composable
fun TabLevelNavHost(
    tab: TabLevelDestination,
) {
    val tabLevelNavController = rememberNavController()

    when (tab) {

        TabLevelDestination.HOME -> NavHost(
            navController = tabLevelNavController,
            startDestination = HomeRoute::class
        ) {
            homeScreen(onClickAddMed = {
                tabLevelNavController.navigateToAddMed(it)
            })
            addMedScreen()
        }

        TabLevelDestination.HISTORY -> NavHost(
            navController = tabLevelNavController,
            startDestination = HistoryRoute::class
        ) {
            historyScreen(onClickAddMed = {
                tabLevelNavController.navigateToAddMed(it)
            })
            addMedScreen()
        }

    }
}