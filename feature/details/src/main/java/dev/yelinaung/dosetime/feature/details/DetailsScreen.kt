package dev.yelinaung.dosetime.feature.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.yelinaung.dosetime.core.model.Medication

@Composable
fun DetailsScreen(medUuid: String) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            medUuid,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}