package dev.yelinaung.dosetime.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import java.util.Date
import java.util.UUID

@Entity(
    tableName = "medication_time",
    primaryKeys = ["medication_uuid", "time"],
    foreignKeys = [
        ForeignKey(
            entity = MedicationEntity::class,
            parentColumns = ["uuid"],
            childColumns = ["medication_uuid"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class MedicationTimeEntity(
    @ColumnInfo(name = "medication_uuid")
    val medicationUuid: UUID,

    @ColumnInfo(name = "time")
    val time: Date,

    @ColumnInfo(name = "dosage")
    val dosage: Float,
)
