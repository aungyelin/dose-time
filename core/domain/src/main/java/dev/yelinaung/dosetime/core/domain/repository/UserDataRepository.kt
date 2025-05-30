package dev.yelinaung.dosetime.core.domain.repository

import dev.yelinaung.dosetime.core.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun setFinishOnboardingStatus(isFinished: Boolean)

}