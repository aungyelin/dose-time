package dev.yelinaung.dosetime.core.data.mapper

import dev.yelinaung.dosetime.core.database.entity.MedicationEntity
import dev.yelinaung.dosetime.core.database.entity.MedicationTimeEntity
import dev.yelinaung.dosetime.core.database.model.PopulatedMedication
import dev.yelinaung.dosetime.core.model.Medication
import dev.yelinaung.dosetime.core.model.MedicationRecurrence
import dev.yelinaung.dosetime.core.model.MedicationTime
import dev.yelinaung.dosetime.core.model.MedicationType
import dev.yelinaung.dosetime.core.model.MedicationUnit

fun PopulatedMedication.toMedication(): Medication {
    return Medication(
        uuid = medication.uuid,
        name = medication.name,
        type = MedicationType.valueOf(medication.type.uppercase()),
        strength = medication.strength,
        unit = MedicationUnit.valueOf(medication.unit.uppercase()),
        recurrence = MedicationRecurrence.valueOf(medication.recurrence.uppercase()),
        times = times.map(MedicationTimeEntity::toMedicationTime),
        startDate = medication.startDate,
        endDate = medication.endDate,
        entryDate = medication.entryDate,
        updateDate = medication.updateDate
    )
}

fun Medication.toPopulatedMedication(): PopulatedMedication {
    return PopulatedMedication(
        medication = MedicationEntity(
            uuid = uuid,
            name = name,
            type = type.name.lowercase(),
            strength = strength,
            unit = unit.name.lowercase(),
            recurrence = recurrence.name.lowercase(),
            startDate = startDate,
            endDate = endDate,
            entryDate = entryDate,
            updateDate = updateDate
        ),
        times = times.map { it.toMedicationTimeEntity(uuid) }
    )
}
