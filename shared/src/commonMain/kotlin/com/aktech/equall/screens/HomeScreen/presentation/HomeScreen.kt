package com.aktech.equall.screens.HomeScreen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.aktech.equall.screens.HomeScreen.presentation.active.ActiveScreen
import com.aktech.equall.screens.HomeScreen.presentation.discovery.DiscoveryScreen
import com.aktech.equall.screens.HomeScreen.presentation.review.ReviewScreen

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(HomeTab.Discovery) }

    Column(modifier = modifier.fillMaxSize()) {
        HomeTabBar(
            selected = selectedTab,
            onSelect = { selectedTab = it },
        )
        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedTab) {
                HomeTab.Discovery -> DiscoveryScreen()
                HomeTab.Review -> ReviewScreen()
                HomeTab.Active -> ActiveScreen()
            }
        }
    }
}
