package dev.yelinaung.dosetime.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import dev.yelinaung.dosetime.feature.main.navigation.mainScreen
import dev.yelinaung.dosetime.feature.main.navigation.navigateToMain
import dev.yelinaung.dosetime.feature.onboarding.navigation.OnboardingGraph
import dev.yelinaung.dosetime.feature.onboarding.navigation.onboardingSection
import dev.yelinaung.dosetime.ui.DoseAppState

@Composable
fun RootNavHost(
    appState: DoseAppState,
    startDestination: Any,
    modifier: Modifier
) {
    val navController = appState.rootNavController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        onboardingSection(
            onClickGetStarted = {
                navController.navigateToMain {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                    restoreState = false
                }
            }
        ) {  }

        mainScreen()

    }
}