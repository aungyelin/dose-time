package dev.yelinaung.dosetime.core.database.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import dev.yelinaung.dosetime.core.database.entity.MedicationEntity
import dev.yelinaung.dosetime.core.database.entity.MedicationTimeEntity

data class PopulatedMedication(
    @Embedded
    val medication: MedicationEntity,

    @Relation(
        parentColumn = "uuid",
        entityColumn = "medication_uuid",
        entity = MedicationTimeEntity::class
    )
    val times: List<MedicationTimeEntity>,
)

