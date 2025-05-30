package dev.yelinaung.dosetime.core.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.yelinaung.dosetime.core.designsystem.icon.DoseIcons

@Composable
fun DoseBottomBar(
    navigationItems: @Composable RowScope.() -> Unit
) {
    NavigationBar {
        navigationItems()
    }
}

@Preview
@Composable
fun DoseBottomBarPreview() {
    DoseBottomBar(
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
                icon = { Icon(DoseIcons.HistoryOutlined, null) },
                label = { Text("History") }
            )
        }
    )
}