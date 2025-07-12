package dev.yelinaung.dosetime.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yelinaung.dosetime.core.domain.usecase.SetFinishOnboardingStatusUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingVM @Inject constructor(
    private val setFinishOnboardingStatusUseCase: SetFinishOnboardingStatusUseCase,
): ViewModel() {

    fun setFinishOnboardingStatus(isFinished: Boolean) {
        viewModelScope.launch {
            setFinishOnboardingStatusUseCase.invoke(isFinished)
        }
    }

}