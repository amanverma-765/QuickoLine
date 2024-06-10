package org.quickoline.dashboard.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.quickoline.domain.usecase.PublicPostDataUseCases

internal class HomeViewModel(
    private val publicPostDataUseCases: PublicPostDataUseCases
): ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiStates())
    val homeUiState =  _homeUiState.asStateFlow()

    fun onEvent(event: HomeUiEvents) {
        when (event) {
            HomeUiEvents.FetchTrendingData -> fetchTrendingData()
        }
    }

    private fun fetchTrendingData() {
        viewModelScope.launch {
            publicPostDataUseCases.getTrendingData().collectLatest { response ->
                _homeUiState.update { state ->
                    state.copy(trendingResponse = response)
                }
            }
        }
    }
}