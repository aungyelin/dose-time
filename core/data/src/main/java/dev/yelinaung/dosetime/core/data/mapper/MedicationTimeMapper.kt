package dev.yelinaung.dosetime.core.data.mapper

import dev.yelinaung.dosetime.core.database.entity.MedicationTimeEntity
import dev.yelinaung.dosetime.core.model.MedicationTime
import java.util.UUID

fun MedicationTimeEntity.toMedicationTime(): MedicationTime {
    return MedicationTime(
        time = time,
        dosage = dosage
    )
}

fun MedicationTime.toMedicationTimeEntity(medicationUuid: UUID): MedicationTimeEntity {
    return MedicationTimeEntity(
        medicationUuid = medicationUuid,
        time = time,
        dosage = dosage
    )
}
