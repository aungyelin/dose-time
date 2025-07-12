package dev.yelinaung.dosetime.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme
import dev.yelinaung.dosetime.feature.main.navigation.MainRoute
import dev.yelinaung.dosetime.feature.onboarding.navigation.OnboardingGraph
import dev.yelinaung.dosetime.navigation.RootNavHost

@Composable
fun DoseTimeApp(
    isOnboarded: Boolean,
) {
    DoseTimeTheme {
        val appState = rememberDoseAppState()

        val firstDestination: Any = if (isOnboarded) MainRoute else OnboardingGraph

        RootNavHost(
            appState = appState,
            startDestination = firstDestination,
            modifier = Modifier.fillMaxSize()
        )
    }
}