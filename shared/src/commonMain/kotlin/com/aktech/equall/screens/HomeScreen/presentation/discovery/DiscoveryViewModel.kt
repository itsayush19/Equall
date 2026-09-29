package com.aktech.equall.screens.HomeScreen.presentation.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aktech.equall.data.repository.DiscoveryRepository
import com.aktech.equall.domain.model.DiscoveryInfo
import com.aktech.equall.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DiscoveryViewModel(
    private val repository: DiscoveryRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<DiscoveryInfo>>(UiState.Loading)
    val state: StateFlow<UiState<DiscoveryInfo>> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            _state.value = try {
                UiState.Success(repository.getDiscovery())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "Unable to load offers")
            }
        }
    }
}