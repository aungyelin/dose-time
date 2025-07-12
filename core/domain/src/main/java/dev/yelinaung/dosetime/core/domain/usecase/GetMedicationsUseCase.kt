package dev.yelinaung.dosetime.core.domain.usecase

import dev.yelinaung.dosetime.core.domain.repository.MedicationsRepository
import dev.yelinaung.dosetime.core.domain.repository.UserDataRepository
import dev.yelinaung.dosetime.core.model.Medication
import dev.yelinaung.dosetime.core.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMedicationsUseCase @Inject constructor(
    private val medicationsRepository: MedicationsRepository,
) {
    operator fun invoke(): Flow<List<Medication>> {
        return medicationsRepository.getMedications()
    }
}