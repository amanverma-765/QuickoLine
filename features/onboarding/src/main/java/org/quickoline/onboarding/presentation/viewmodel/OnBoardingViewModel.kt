package org.quickoline.onboarding.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.quickoline.domain.usecase.DataStoreUseCases
import org.quickoline.utils.Constants.POLICY_KEY
import org.quickoline.utils.Constants.USER_ENTRY_KEY

internal class OnBoardingViewModel(
    private val dataStoreUseCases: DataStoreUseCases
) : ViewModel() {

    private val _onBoardingState = MutableStateFlow(OnBoardingUiStates())
    val onBoardingState = _onBoardingState.asStateFlow()

    fun onEvent(event: OnBoardingUiEvents) {
        when (event) {
            is OnBoardingUiEvents.SaveUserEntryState -> saveUserEntryState()
            is OnBoardingUiEvents.SavePolicyState -> savePolicyState(event.isAccepted)
        }
    }

    private fun saveUserEntryState() {
        viewModelScope.launch {
            dataStoreUseCases.saveToDataStore(data = true, key = USER_ENTRY_KEY).collect { result ->
                Log.e("TAG", "saveUserEntryState: $result")
                _onBoardingState.update { uiState ->
                    uiState.copy(userEntryResponse = result)
                }
            }
        }
    }

    private fun savePolicyState(isAccepted: Boolean) {
        viewModelScope.launch {
           dataStoreUseCases.saveToDataStore(data = isAccepted, key = POLICY_KEY).collect { result ->
               _onBoardingState.update { uiState ->
                   uiState.copy(
                       policyAccepted = isAccepted,
                       policyResponse = result
                   )
               }
           }
        }
    }
}