package dev.yelinaung.dosetime.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import dev.yelinaung.dosetime.feature.addmed.navigation.addMedScreen
import dev.yelinaung.dosetime.feature.addmed.navigation.navigateToAddMed
import dev.yelinaung.dosetime.feature.details.navigation.detailsScreen
import dev.yelinaung.dosetime.feature.details.navigation.navigateToDetails
import dev.yelinaung.dosetime.feature.home.navigation.HomeRoute
import dev.yelinaung.dosetime.feature.home.navigation.homeScreen
import dev.yelinaung.dosetime.feature.main.TabLevelScreenState
import dev.yelinaung.dosetime.feature.medications.navigation.MedicationsRoute
import dev.yelinaung.dosetime.feature.medications.navigation.medicationsScreen

@Composable
fun TabLevelNavHost(
    tab: TabLevelDestination,
    tabLevelScreenState: TabLevelScreenState
) {
    val navController = tabLevelScreenState.tabLevelNavController

    when (tab) {

        TabLevelDestination.HOME -> NavHost(
            navController = navController,
            startDestination = HomeRoute::class
        ) {
            homeScreen()
        }

        TabLevelDestination.Medications -> NavHost(
            navController = navController,
            startDestination = MedicationsRoute::class
        ) {
            medicationsScreen(
                onClickAddMed = { navController.navigateToAddMed() },
                onClickMed = { navController.navigateToDetails(it.uuid.toString()) }
            )
            detailsScreen()
            addMedScreen(
                onClickBack = { navController.popBackStack() },
                onFinish = { navController.popBackStack() }
            )
        }

    }
}