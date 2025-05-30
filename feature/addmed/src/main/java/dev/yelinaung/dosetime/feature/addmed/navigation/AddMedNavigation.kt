package dev.yelinaung.dosetime.feature.addmed.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import dev.yelinaung.dosetime.feature.addmed.AddMedScreen
import kotlinx.serialization.Serializable

@Serializable
data class AddMedRoute(val text: String)

fun NavController.navigateToAddMed(
    text: String,
    navOptions: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = AddMedRoute(text), navOptions)
}

fun NavGraphBuilder.addMedScreen() {
    composable<AddMedRoute> {
        val text = it.toRoute<AddMedRoute>().text
        AddMedScreen(text)
    }
}