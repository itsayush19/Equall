package com.aktech.equall.di

import com.aktech.equall.screens.HomeScreen.presentation.active.ActiveViewModel
import com.aktech.equall.screens.HomeScreen.presentation.discovery.DiscoveryViewModel
import com.aktech.equall.screens.HomeScreen.presentation.review.ReviewViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DiscoveryViewModel(get()) }
    viewModel { ReviewViewModel(get()) }
    viewModel { ActiveViewModel(get()) }
}
