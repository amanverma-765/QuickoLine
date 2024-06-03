package org.quickoline.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MainViewModel : ViewModel() {

    private val _mainState = MutableStateFlow(MainUiStates())
    val mainState = _mainState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(500)
            _mainState.update { state ->
                state.copy(
                    shouldShowSplash = false
                )
            }
        }
    }
}