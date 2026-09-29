package com.aktech.equall

import androidx.compose.ui.window.ComposeUIViewController
import com.aktech.equall.di.initKoin
import com.aktech.equall.screens.MainScreen

private var koinStarted = false

fun MainViewController() = ComposeUIViewController {
    if (!koinStarted) {
        initKoin()
        koinStarted = true
    }
    MainScreen()
}
