package dev.yelinaung.dosetime.core.domain.repository

import dev.yelinaung.dosetime.core.model.Medication
import kotlinx.coroutines.flow.Flow

interface MedicationsRepository {

    suspend fun addMedication(medication: Medication)

    fun getMedications(): Flow<List<Medication>>

}