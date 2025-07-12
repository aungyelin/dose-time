package dev.yelinaung.dosetime.core.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.yelinaung.dosetime.core.designsystem.icon.DoseIcons
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme

@Composable
fun DoseToolBar(
    navigationItems: @Composable RowScope.() -> Unit
) {
    NavigationBar {
        navigationItems()
    }
}

@ThemePreviews
@Composable
fun DoseBottomBarPreview() {
    DoseTimeTheme {
        DoseToolBar(
            navigationItems = {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(DoseIcons.Home, null) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(DoseIcons.MedicationsOutlined, null) },
                    label = { Text("History") }
                )
            }
        )
    }
}