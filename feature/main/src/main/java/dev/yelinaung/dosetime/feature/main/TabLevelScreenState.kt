package dev.yelinaung.dosetime.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dev.yelinaung.dosetime.feature.main.navigation.TabLevelDestination
import dev.yelinaung.dosetime.feature.main.navigation.navigateToHomeTab
import dev.yelinaung.dosetime.feature.main.navigation.navigateToMedicationsTab

@Composable
fun rememberTabLevelScreenState(
    tabLevelNavController: NavHostController = rememberNavController(),
): TabLevelScreenState {
    return remember(
        tabLevelNavController,
    ) {
        TabLevelScreenState(
            tabLevelNavController = tabLevelNavController
        )
    }
}

@Stable
class TabLevelScreenState(
    val tabLevelNavController: NavHostController
) {
    fun popupToStartDestination() {
        tabLevelNavController.popBackStack(
            tabLevelNavController.graph.findStartDestination().id,
            inclusive = false,
            saveState = false
        )
    }
}