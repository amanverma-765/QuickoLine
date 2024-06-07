package org.quickoline.dashboard.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class HomeViewModel: ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiStates())
    val homeUiState =  _homeUiState.asStateFlow()

    fun onEvent(event: HomeUiEvents) {
        when (event) {
            else -> {}
        }
    }
}