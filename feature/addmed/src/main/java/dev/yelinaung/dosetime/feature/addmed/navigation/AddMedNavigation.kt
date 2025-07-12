package dev.yelinaung.dosetime.feature.addmed.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.feature.addmed.AddMedScreen
import kotlinx.serialization.Serializable

@Serializable
data object AddMedRoute

fun NavController.navigateToAddMed(
    navOptions: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = AddMedRoute, navOptions)
}

fun NavGraphBuilder.addMedScreen(
    onClickBack: () -> Unit,
    onFinish: () -> Unit,
) {
    composable<AddMedRoute> {
        AddMedScreen(
            onClickBack = onClickBack,
            onFinish = onFinish
        )
    }
}