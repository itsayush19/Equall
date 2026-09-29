package com.aktech.equall.screens.HomeScreen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aktech.equall.screens.HomeScreen.presentation.active.ActiveContent
import com.aktech.equall.screens.HomeScreen.presentation.discovery.DiscoveryContent
import com.aktech.equall.screens.HomeScreen.presentation.review.ReviewContent
import com.aktech.equall.utils.ErrorView
import com.aktech.equall.utils.LoadingView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(modifier = modifier.fillMaxSize()) {
        HomeTabBar(
            selected = state.selectedTab,
            onSelect = viewModel::onTabSelected,
        )
        Box(modifier = Modifier.fillMaxSize()) {
            when (val content = state.content) {
                HomeContentState.Loading -> LoadingView()
                is HomeContentState.Error -> ErrorView(message = content.message, onRetry = viewModel::load)
                is HomeContentState.Discovery -> DiscoveryContent(content.data)
                is HomeContentState.Review -> ReviewContent(content.data)
                is HomeContentState.Active -> ActiveContent(content.data)
            }
        }
    }
}
