package dev.yelinaung.dosetime.feature.addmed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yelinaung.dosetime.core.domain.usecase.AddMedicationUseCase
import dev.yelinaung.dosetime.core.domain.usecase.GetMedicationsUseCase
import dev.yelinaung.dosetime.core.model.Medication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMedicationsVM @Inject constructor(
    private val addMedicationUseCase: AddMedicationUseCase,
) : ViewModel() {

    fun addMedication(medication: Medication) = viewModelScope.launch {
        addMedicationUseCase.invoke(medication)
    }

}