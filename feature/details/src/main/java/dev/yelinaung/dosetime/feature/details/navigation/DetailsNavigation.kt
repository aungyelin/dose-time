package dev.yelinaung.dosetime.feature.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.yelinaung.dosetime.core.model.Medication
import dev.yelinaung.dosetime.feature.details.DetailsScreen
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class DetailsRoute(val medUuid: String)

fun NavController.navigateToDetails(
    medUuid: String,
    navOptions: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = DetailsRoute(medUuid), navOptions)
}

fun NavGraphBuilder.detailsScreen() {
    composable<DetailsRoute> {
        val med = it.toRoute<DetailsRoute>().medUuid
        DetailsScreen(med)
    }
}