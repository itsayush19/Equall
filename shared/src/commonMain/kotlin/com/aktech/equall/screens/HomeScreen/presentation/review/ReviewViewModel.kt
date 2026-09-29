package com.aktech.equall.screens.HomeScreen.presentation.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aktech.equall.data.repository.ReviewRepository
import com.aktech.equall.domain.model.ReviewInfo
import com.aktech.equall.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReviewViewModel(
    private val repository: ReviewRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<ReviewInfo>>(UiState.Loading)
    val state: StateFlow<UiState<ReviewInfo>> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            _state.value = try {
                UiState.Success(repository.getReview())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "Unable to load application status")
            }
        }
    }
}