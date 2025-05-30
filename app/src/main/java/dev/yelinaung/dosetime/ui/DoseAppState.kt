package dev.yelinaung.dosetime.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberDoseAppState(
    rootNavController: NavHostController = rememberNavController(),
): DoseAppState {
    return remember(
        rootNavController,
    ) {
        DoseAppState(
            rootNavController = rootNavController,
        )
    }
}

@Stable
class DoseAppState(
    val rootNavController: NavHostController,
)