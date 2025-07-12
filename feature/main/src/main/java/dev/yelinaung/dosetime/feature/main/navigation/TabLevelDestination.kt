package dev.yelinaung.dosetime.feature.main.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import dev.yelinaung.dosetime.core.designsystem.icon.DoseIcons
import kotlin.reflect.KClass
import dev.yelinaung.dosetime.feature.medications.R as medicationR
import dev.yelinaung.dosetime.feature.home.R as homeR

enum class TabLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>
) {
    HOME(
        selectedIcon = DoseIcons.Home,
        unselectedIcon = DoseIcons.HomeOutlined,
        iconTextId = homeR.string.feature_home_tab,
        titleTextId = homeR.string.feature_home_tab,
        route = HomeTabRoute::class
    ),
    Medications(
        selectedIcon = DoseIcons.Medications,
        unselectedIcon = DoseIcons.MedicationsOutlined,
        iconTextId = medicationR.string.feature_medications_tab,
        titleTextId = medicationR.string.feature_medications_tab,
        route = MedicationsTabRoute::class
    )
}