package org.quickoline.dashboard.presentation.viewmodel.userentry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.quickoline.domain.usecase.DataStoreUseCases
import org.quickoline.utils.Constants.POLICY_KEY
import org.quickoline.utils.Constants.USER_ENTRY_KEY

internal class UserEntryViewModel(
    private val dataStoreUseCases: DataStoreUseCases
): ViewModel() {

    private val _userEntryState = MutableStateFlow(UserEntryUiStates())
    val userEntryState = _userEntryState.asStateFlow()

    fun onEvent(event: UserEntryUiEvents) {
        when (event) {
            UserEntryUiEvents.CheckIfOnBoardingIsCompleted -> checkIfOnBoardingIsCompleted()
        }
    }

    private fun checkIfOnBoardingIsCompleted() {
        viewModelScope.launch {
            getPolicyState()
            getUserEntryState()
        }
    }

    private fun getPolicyState() {
        viewModelScope.launch {
            dataStoreUseCases.getFromDataStore(key = POLICY_KEY).collect { result ->
                _userEntryState.update { state ->
                    state.copy(policyResponse = result)
                }
            }
        }
    }

    private fun getUserEntryState() {
        viewModelScope.launch {
            dataStoreUseCases.getFromDataStore(key = USER_ENTRY_KEY).collect { result ->
                _userEntryState.update { state ->
                    state.copy(userEntryResponse = result)
                }
            }
        }
    }
}