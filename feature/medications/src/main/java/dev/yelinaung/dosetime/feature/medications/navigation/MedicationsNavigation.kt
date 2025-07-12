package dev.yelinaung.dosetime.feature.medications.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.yelinaung.dosetime.core.model.Medication
import dev.yelinaung.dosetime.feature.medications.MedicationsScreen
import kotlinx.serialization.Serializable

@Serializable
data object MedicationsRoute

fun NavController.navigateToMedications(navOptions: NavOptions) {
    navigate(route = MedicationsRoute, navOptions)
}

fun NavGraphBuilder.medicationsScreen(
    onClickAddMed: () -> Unit,
    onClickMed: (med: Medication) -> Unit
) {
    composable<MedicationsRoute> {
        MedicationsScreen(onClickAddMed, onClickMed)
    }
}
