package dev.yelinaung.dosetime.core.domain.usecase

import dev.yelinaung.dosetime.core.domain.repository.UserDataRepository
import dev.yelinaung.dosetime.core.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository,
) {
    operator fun invoke(): Flow<UserData> {
        return userDataRepository.userData
    }
}