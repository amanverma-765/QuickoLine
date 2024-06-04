package org.quickoline.home.presentation.viewmodel.userentry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.quickoline.home.domain.userentry.usecases.UserEntryUseCases

internal class UserEntryViewModel(
    private val userEntryUseCases: UserEntryUseCases
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
            delay(700)
            getPolicyState()
            getUserEntryState()
        }
    }

    private fun getPolicyState() {
        viewModelScope.launch {
            userEntryUseCases.getPolicyState().collect { isAccepted ->
                _userEntryState.update { state ->
                    state.copy(isPolicyAccepted = isAccepted)
                }
            }
        }
    }

    private fun getUserEntryState() {
        viewModelScope.launch {
            userEntryUseCases.getUserEntryState().collect { isCompleted ->
                _userEntryState.update { state ->
                    state.copy(isEntryCompleted = isCompleted)
                }
            }
        }
    }
}