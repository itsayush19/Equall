package com.aktech.equall.screens.HomeScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aktech.equall.data.repository.HomeRepository
import com.aktech.equall.domain.model.HomeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: HomeRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    private var homeData: HomeData? = null

    init {
        load()
    }

    /** Fetches the whole Home payload once, then builds the current tab's content. */
    fun load() {
        viewModelScope.launch {
            _state.update { it.copy(content = HomeContentState.Loading) }
            runCatching { repository.getHome() }
                .onSuccess { data ->
                    homeData = data
                    _state.update { it.copy(content = contentFor(it.selectedTab, data)) }
                }
                .onFailure { e ->
                    _state.update { it.copy(content = HomeContentState.Error(e.message ?: "Something went wrong")) }
                }
        }
    }

    /** Tab click: switch tabs and rebuild the screen state from the already-loaded data. */
    fun onTabSelected(tab: HomeTab) {
        val data = homeData
        _state.update {
            it.copy(
                selectedTab = tab,
                content = if (data != null) contentFor(tab, data) else it.content,
            )
        }
    }

    private fun contentFor(tab: HomeTab, data: HomeData): HomeContentState =
        when (tab) {
            HomeTab.Discovery -> HomeContentState.Discovery(data.discovery)
            HomeTab.Review -> HomeContentState.Review(data.review)
            HomeTab.Active -> HomeContentState.Active(data.active)
        }
}
