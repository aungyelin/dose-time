package dev.yelinaung.dosetime.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.yelinaung.dosetime.core.database.dao.MedicationDao
import dev.yelinaung.dosetime.core.database.entity.MedicationEntity
import dev.yelinaung.dosetime.core.database.entity.MedicationTimeEntity
import dev.yelinaung.dosetime.core.database.util.DateConverter
import dev.yelinaung.dosetime.core.database.util.UUIDConverter

@Database(
    entities = [
        MedicationEntity::class,
        MedicationTimeEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    DateConverter::class,
    UUIDConverter::class
)
internal abstract class DoseDatabase : RoomDatabase() {

    abstract fun medicationDao(): MedicationDao

}