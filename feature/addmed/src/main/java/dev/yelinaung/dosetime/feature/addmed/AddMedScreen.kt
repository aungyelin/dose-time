package dev.yelinaung.dosetime.feature.addmed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AddMedScreen(text: String) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}