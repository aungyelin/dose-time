package dev.yelinaung.dosetime.core.model

import java.util.Date
import java.util.UUID

data class MedicationTime(
    val time: Date,
    val dosage: Float
)
