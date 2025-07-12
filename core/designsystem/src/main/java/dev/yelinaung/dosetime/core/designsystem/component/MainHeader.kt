package dev.yelinaung.dosetime.core.designsystem.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme

@Composable
fun MainHeader(title: String) {
    Row(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@ThemePreviews
@Composable
fun MainHeaderPreview() {
    DoseTimeTheme {
        MainHeader(
            title = "Dose Time"
        )
    }
}