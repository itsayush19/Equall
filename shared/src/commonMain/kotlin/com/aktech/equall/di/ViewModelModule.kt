package com.aktech.equall.di

import com.aktech.equall.screens.HomeScreen.presentation.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
