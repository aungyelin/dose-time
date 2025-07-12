package dev.yelinaung.dosetime.feature.medications

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
class MedicationsVM @Inject constructor(
    private val getMedicationsUseCase: GetMedicationsUseCase,
) : ViewModel() {

    private val _medications = MutableStateFlow<List<Medication>>(emptyList())
    val medications = _medications.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getMedicationsUseCase.invoke().distinctUntilChanged().collect {
                _medications.value = it
            }
        }
    }

}