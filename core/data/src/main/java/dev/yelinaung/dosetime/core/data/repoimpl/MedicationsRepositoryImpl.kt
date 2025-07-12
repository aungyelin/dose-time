package dev.yelinaung.dosetime.core.data.repoimpl

import dev.yelinaung.dosetime.core.data.mapper.toMedication
import dev.yelinaung.dosetime.core.data.mapper.toPopulatedMedication
import dev.yelinaung.dosetime.core.database.dao.MedicationDao
import dev.yelinaung.dosetime.core.domain.repository.MedicationsRepository
import dev.yelinaung.dosetime.core.model.Medication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MedicationsRepositoryImpl @Inject constructor(
    private val medicationDao: MedicationDao,
) : MedicationsRepository {

    override suspend fun addMedication(medication: Medication) {
        medicationDao.insertMedication(medication.toPopulatedMedication())
    }

    override fun getMedications(): Flow<List<Medication>> {
        return medicationDao.getAllMedications().map { entities ->
            entities.map { it.toMedication() }
        }
    }

}