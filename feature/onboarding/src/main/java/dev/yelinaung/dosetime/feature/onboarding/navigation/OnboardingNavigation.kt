package dev.yelinaung.dosetime.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.yelinaung.dosetime.feature.onboarding.OnboardingScreen
import kotlinx.serialization.Serializable

@Serializable
data object OnboardingGraph

@Serializable
data object OnboardingRoute

fun NavController.navigateToOnboarding() {
    navigate(route = OnboardingRoute)
}

fun NavGraphBuilder.onboardingSection(
    onClickGetStarted: () -> Unit,
    subDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<OnboardingGraph>(startDestination = OnboardingRoute) {
        composable<OnboardingRoute> {
            OnboardingScreen(onClickGetStarted = onClickGetStarted)
        }
        subDestination()
    }
}