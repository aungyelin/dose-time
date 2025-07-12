package dev.yelinaung.dosetime.feature.medications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yelinaung.dosetime.core.designsystem.component.ThemePreviews
import dev.yelinaung.dosetime.core.designsystem.icon.DoseIcons
import dev.yelinaung.dosetime.core.designsystem.theme.DoseTimeTheme
import dev.yelinaung.dosetime.core.model.Medication
import dev.yelinaung.dosetime.feature.medications.R as medicationsR

@Composable
fun MedicationsScreen(
    onClickAddMed: () -> Unit,
    onClickMed: (med: Medication) -> Unit,
    viewModel: MedicationsVM = hiltViewModel()
) {
    val medications = viewModel.medications.collectAsState().value

    MedicationsScreen(
        onClickAddMed,
        onClickMed,
        medications
    )
}

@Composable
internal fun MedicationsScreen(
    onClickAddMed: () -> Unit,
    onClickMed: (med: Medication) -> Unit,
    medications: List<Medication>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            if (medications.isEmpty()) {
                item {
                    NoMedicationPlaceholder()
                    Spacer(modifier = Modifier.height(16.dp))
                }
            } else {
                items(medications) {
                    MedicationView(it, onClickMed)
                }
            }
            item {
                AddMedicationView(onClickAddMed)
                /*viewModel.addMedication(
                        Medication(
                            uuid = UUID.randomUUID(),
                            name = "Paracetamol",
                            type = MedicationType.TABLET,
                            strength = 500f,
                            unit = MedicationUnit.MG,
                            recurrence = MedicationRecurrence.DAILY,
                            times = listOf(
                                MedicationTime(
                                    time = Date.from(Instant.now()),
                                    dosage = 1f
                                ),
                                MedicationTime(
                                    time = Date.from(Instant.now().plus(5, ChronoUnit.MINUTES)),
                                    dosage = 2f
                                ),
                                MedicationTime(
                                    time = Date.from(Instant.now().plus(15, ChronoUnit.MINUTES)),
                                    dosage = 1.5f
                                )
                            ),
                            startDate = Date.from(Instant.now()),
                            endDate = null,
                            entryDate = Date.from(Instant.now()),
                            updateDate = Date.from(Instant.now())
                        )
                    )*/
            }
        }
    }
}

@Composable
private fun NoMedicationPlaceholder() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(130.dp),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

            }
            Image(
                painter = painterResource(medicationsR.drawable.ic_doctor_long_hair),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f, true)
                    .padding(top = 10.dp)
            )
        }
    }
}

@Composable
private fun MedicationView(
    medication: Medication,
    onClickMed: (med: Medication) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        onClick = { onClickMed.invoke(medication) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colorScheme.inversePrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = DoseIcons.Medications,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = medication.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = medication.type.name.lowercase().replaceFirstChar { it.uppercase() },
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = medication.recurrence.name.lowercase()
                        .replaceFirstChar { it.uppercase() },
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Icon(
                imageVector = DoseIcons.RightArrow,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
private fun AddMedicationView(onClickAddMed: () -> Unit) {
    Text(
        text = "Add Medication",
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClickAddMed.invoke()
            }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        color = MaterialTheme.colorScheme.onPrimary,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = stringResource(medicationsR.string.feature_medications_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Preview
@Composable
private fun MedicationsScreenPreview() {
    DoseTimeTheme {
        MedicationsScreen(
            onClickAddMed = {},
            onClickMed = {},
            medications = emptyList()
        )
    }
}