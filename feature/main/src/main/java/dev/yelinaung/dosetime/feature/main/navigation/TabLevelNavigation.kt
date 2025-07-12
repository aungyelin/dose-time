package dev.yelinaung.dosetime.feature.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import kotlinx.serialization.Serializable

@Serializable
data object HomeTabRoute

fun NavController.navigateToHomeTab(navOptions: NavOptions) {
    navigate(route = HomeTabRoute, navOptions)
}

@Serializable
data object MedicationsTabRoute

fun NavController.navigateToMedicationsTab(navOptions: NavOptions) {
    navigate(route = MedicationsTabRoute, navOptions)
}