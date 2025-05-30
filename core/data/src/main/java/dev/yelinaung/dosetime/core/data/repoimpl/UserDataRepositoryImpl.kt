package dev.yelinaung.dosetime.core.data.repoimpl

import dev.yelinaung.dosetime.core.datastore.DosePreferencesDataSource
import dev.yelinaung.dosetime.core.domain.repository.UserDataRepository
import dev.yelinaung.dosetime.core.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val dosePreferencesDataSource: DosePreferencesDataSource,
): UserDataRepository {

    override val userData: Flow<UserData> = dosePreferencesDataSource.userData

    override suspend fun setFinishOnboardingStatus(isFinished: Boolean) {
        dosePreferencesDataSource.setFinishOnboardingStatus(isFinished)
    }

}