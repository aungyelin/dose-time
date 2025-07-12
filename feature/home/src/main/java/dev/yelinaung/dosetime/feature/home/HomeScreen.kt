package dev.yelinaung.dosetime.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.yelinaung.dosetime.core.designsystem.component.MainHeader
import dev.yelinaung.dosetime.core.designsystem.component.ThemePreviews
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainHeader(title = "Today")
    }
}

@ThemePreviews
@Composable
private fun MainScreenPreview() {
    DoseTimeTheme {
        HomeScreen()
    }
}