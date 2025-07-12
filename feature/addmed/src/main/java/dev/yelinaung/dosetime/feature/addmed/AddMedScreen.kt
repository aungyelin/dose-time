package dev.yelinaung.dosetime.feature.addmed

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yelinaung.dosetime.core.designsystem.component.DevicePreviews
import dev.yelinaung.dosetime.core.designsystem.component.DoseToolBar
import dev.yelinaung.dosetime.core.designsystem.component.ThemePreviews
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme
import dev.yelinaung.dosetime.core.model.Medication

@Composable
fun AddMedScreen(
    onClickBack: () -> Unit,
    onFinish: () -> Unit,
    viewModel: AddMedicationsVM = hiltViewModel()
) {
    AddMedScreen(
        onClickBack,
        onFinish,
        addMedication = viewModel::addMedication
    )
}

@Composable
internal fun AddMedScreen(
    onClickBack: () -> Unit,
    onFinish: () -> Unit,
    addMedication: (Medication) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        DoseToolBar(
            title = "Add Medication",
            onBackClick = onClickBack
        )
    }
}

@ThemePreviews
@Composable
fun AddMedScreenPreview() {
    DoseTimeTheme {
        AddMedScreen(
            onClickBack = {},
            onFinish = {},
            addMedication = {}
        )
    }
}