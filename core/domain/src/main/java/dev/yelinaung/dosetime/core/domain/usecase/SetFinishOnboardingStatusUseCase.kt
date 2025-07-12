package dev.yelinaung.dosetime.core.domain.usecase

import dev.yelinaung.dosetime.core.domain.repository.UserDataRepository
import dev.yelinaung.dosetime.core.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetFinishOnboardingStatusUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository,
) {
    suspend operator fun invoke(isFinished: Boolean) {
        return userDataRepository.setFinishOnboardingStatus(isFinished)
    }
}