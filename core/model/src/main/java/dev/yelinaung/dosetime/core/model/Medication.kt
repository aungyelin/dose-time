package dev.yelinaung.dosetime.core.model

import java.util.Date
import java.util.UUID

data class Medication(
    val uuid: UUID,
    val name: String,
    val type: MedicationType,
    val strength: Float,
    val unit: MedicationUnit,
    val recurrence: MedicationRecurrence,
    val times: List<MedicationTime>,
    val startDate: Date,
    val endDate: Date?,
    val entryDate: Date,
    val updateDate: Date,
)
