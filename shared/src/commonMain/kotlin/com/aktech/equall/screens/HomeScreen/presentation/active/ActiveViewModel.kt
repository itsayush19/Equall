package com.aktech.equall.screens.HomeScreen.presentation.active

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aktech.equall.data.repository.ActiveRepository
import com.aktech.equall.domain.model.ActiveLoan
import com.aktech.equall.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ActiveViewModel(
    private val repository: ActiveRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<ActiveLoan>>(UiState.Loading)
    val state: StateFlow<UiState<ActiveLoan>> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            _state.value = try {
                UiState.Success(repository.getActive())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "Unable to load loan details")
            }
        }
    }
}