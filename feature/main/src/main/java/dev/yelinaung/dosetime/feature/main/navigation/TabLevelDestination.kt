package dev.yelinaung.dosetime.feature.main.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import dev.yelinaung.dosetime.core.designsystem.icon.DoseIcons
import kotlin.reflect.KClass
import dev.yelinaung.dosetime.feature.history.R as historyR
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
        iconTextId = homeR.string.feature_home_title,
        titleTextId = homeR.string.feature_home_title,
        route = HomeTabRoute::class
    ),
    HISTORY(
        selectedIcon = DoseIcons.History,
        unselectedIcon = DoseIcons.HistoryOutlined,
        iconTextId = historyR.string.feature_history_title,
        titleTextId = historyR.string.feature_history_title,
        route = HistoryTabRoute::class
    )
}