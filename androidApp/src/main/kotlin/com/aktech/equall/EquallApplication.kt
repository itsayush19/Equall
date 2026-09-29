package com.aktech.equall

import android.app.Application
import com.aktech.equall.di.initKoin

class EquallApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
