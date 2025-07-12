package dev.yelinaung.dosetime.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dev.yelinaung.dosetime.feature.main.navigation.TabLevelDestination
import dev.yelinaung.dosetime.feature.main.navigation.navigateToHomeTab
import dev.yelinaung.dosetime.feature.main.navigation.navigateToMedicationsTab

@Composable
fun rememberMainScreenState(
    mainNavController: NavHostController = rememberNavController(),
): MainScreenState {
    return remember(
        mainNavController,
    ) {
        MainScreenState(
            mainNavController = mainNavController
        )
    }
}

@Stable
class MainScreenState(
    val mainNavController: NavHostController,
) {
    val tabLevelDestinations = TabLevelDestination.entries

    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            val currentEntry = mainNavController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            // Fallback to previousDestination if currentEntry is null
            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    val currentTabLevelDestination: TabLevelDestination?
        @Composable get() {
            return tabLevelDestinations.firstOrNull { topLevelDestination ->
                currentDestination?.hasRoute(topLevelDestination.route) == true
            }
        }

    fun navigateToTabLevelDestination(tapLevelDestination: TabLevelDestination) {

        val nOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(mainNavController.graph.findStartDestination().id) {
                saveState = true
            }

            // Avoid multiple copies of the same destination when
            // re-selecting the same item
            launchSingleTop = true

            // Restore state when re-selecting a previously selected item
            restoreState = true
        }

        when (tapLevelDestination) {
            TabLevelDestination.HOME -> mainNavController.navigateToHomeTab(nOptions)
            TabLevelDestination.Medications -> mainNavController.navigateToMedicationsTab(nOptions)
        }

    }
}