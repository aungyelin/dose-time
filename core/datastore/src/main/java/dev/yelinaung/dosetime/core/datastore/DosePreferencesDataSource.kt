package dev.yelinaung.dosetime.core.datastore

import androidx.datastore.core.DataStore
import dev.yelinaung.dosetime.core.model.ThemeConfig
import dev.yelinaung.dosetime.core.model.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DosePreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data.map {
        UserData(
            finishedOnboarding = it.finishedOnboarding,
            themeConfig = when (it.themeConfig) {
                null,
                ThemeConfigProto.UNRECOGNIZED,
                ThemeConfigProto.THEME_CONFIG_UNSPECIFIED,
                ThemeConfigProto.THEME_CONFIG_FOLLOW_SYSTEM -> ThemeConfig.FOLLOW_SYSTEM
                ThemeConfigProto.THEME_CONFIG_LIGHT -> ThemeConfig.LIGHT
                ThemeConfigProto.THEME_CONFIG_DARK -> ThemeConfig.DARK
            }
        )
    }

    suspend fun setFinishOnboardingStatus(isFinished: Boolean) {
        userPreferences.updateData {
            it.copy { this.finishedOnboarding = isFinished }
        }
    }
}