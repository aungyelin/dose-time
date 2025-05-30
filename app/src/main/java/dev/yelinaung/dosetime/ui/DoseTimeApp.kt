package dev.yelinaung.dosetime.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
            ) {
                val appState = rememberDoseAppState()

                val firstDestination: Any = if (isOnboarded) MainRoute else OnboardingGraph

                RootNavHost(
                    appState = appState,
                    startDestination = firstDestination,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                )
            }
        }
    }
}