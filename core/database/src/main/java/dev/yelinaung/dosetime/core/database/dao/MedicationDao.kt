package dev.yelinaung.dosetime.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import dev.yelinaung.dosetime.core.database.entity.MedicationEntity
import dev.yelinaung.dosetime.core.database.entity.MedicationTimeEntity
import dev.yelinaung.dosetime.core.database.model.PopulatedMedication
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface MedicationDao {

    /**
     * Medications with times
     */
    @Query("SELECT * FROM medication")
    fun getAllMedications(): Flow<List<PopulatedMedication>>

    @Query("SELECT * FROM medication WHERE uuid = :uuid")
    suspend fun getMedicationById(uuid: UUID): PopulatedMedication?

    @Transaction
    suspend fun insertMedication(populatedMedication: PopulatedMedication) {
        insertMedication(populatedMedication.medication)
        insertTimes(populatedMedication.times)
    }

    /**
     * Medication
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedication(medicationEntity: MedicationEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMedication(medicationEntity: MedicationEntity)

    @Upsert
    suspend fun upsertMedication(medicationEntity: MedicationEntity)

    @Delete
    suspend fun deleteMedication(medicationEntity: MedicationEntity)

    /**
     * Times
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimes(times: List<MedicationTimeEntity>)

}