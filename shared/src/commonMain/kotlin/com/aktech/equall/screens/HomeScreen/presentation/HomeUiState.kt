package com.aktech.equall.screens.HomeScreen.presentation

import com.aktech.equall.domain.model.ActiveLoan
import com.aktech.equall.domain.model.DiscoveryInfo
import com.aktech.equall.domain.model.ReviewInfo

/**
 * State of the currently selected Home tab, built from the single Home payload.
 * Loading / Error apply to the one-shot fetch; the tab variants are the loaded content.
 */
sealed class HomeContentState {
    data object Loading : HomeContentState()
    data class Error(val message: String) : HomeContentState()
    data class Discovery(val data: DiscoveryInfo) : HomeContentState()
    data class Review(val data: ReviewInfo) : HomeContentState()
    data class Active(val data: ActiveLoan) : HomeContentState()
}

data class HomeScreenState(
    val selectedTab: HomeTab = HomeTab.Discovery,
    val content: HomeContentState = HomeContentState.Loading,
)
