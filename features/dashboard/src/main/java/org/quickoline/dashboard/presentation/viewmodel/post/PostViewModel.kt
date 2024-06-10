package org.quickoline.dashboard.presentation.viewmodel.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.domain.usecase.PublicPostDataUseCases

internal class PostViewModel(
    private val publicPostDataUseCases: PublicPostDataUseCases
) : ViewModel() {

    private val _postUiState = MutableStateFlow(PostUiStates())
    val postUiState = _postUiState.asStateFlow()

    fun onEvent(event: PostUiEvents) {
        when (event) {
            is PostUiEvents.FetchPostData -> fetchPostData(event.category)
        }
    }
    private fun fetchPostData(category: Category) {
        viewModelScope.launch {
            val responseFlow = when (category) {
                Category.FORM_FILLING -> publicPostDataUseCases.getFormFillingData()
                Category.LEGAL_WORK -> publicPostDataUseCases.getLegalServiceData()
                Category.LAST_MINUTE -> publicPostDataUseCases.getLastMinuteData()
                Category.MORE_SERVICES -> publicPostDataUseCases.getLastMinuteData()
            }

            responseFlow.collectLatest { response ->
                _postUiState.update { state ->
                    state.copy(postResponse = response)
                }
            }
        }
    }
}