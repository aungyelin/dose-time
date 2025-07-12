package dev.yelinaung.dosetime.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(
    tableName = "medication"
)
data class MedicationEntity(
    @PrimaryKey
    val uuid: UUID,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "strength")
    val strength: Float,

    @ColumnInfo(name = "unit")
    val unit: String,

    @ColumnInfo(name = "recurrence")
    val recurrence: String,

    @ColumnInfo(name = "start_date")
    val startDate: Date,

    @ColumnInfo(name = "end_date")
    val endDate: Date?,

    @ColumnInfo(name = "entry_date")
    val entryDate: Date,

    @ColumnInfo(name = "update_date")
    val updateDate: Date,
)
