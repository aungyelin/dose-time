package dev.yelinaung.dosetime.feature.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HistoryScreen(
    onClickAddMed: (str: String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { onClickAddMed.invoke("Med from History") },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text("Add Med from History")
            }
        }
    }
}