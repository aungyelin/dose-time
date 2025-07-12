package dev.yelinaung.dosetime.core.domain.usecase

import dev.yelinaung.dosetime.core.domain.repository.MedicationsRepository
import dev.yelinaung.dosetime.core.model.Medication
import javax.inject.Inject

class AddMedicationUseCase @Inject constructor(
    private val medicationsRepository: MedicationsRepository,
) {
    suspend operator fun invoke(medication: Medication) {
        medicationsRepository.addMedication(medication)
    }
}