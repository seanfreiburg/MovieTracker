package com.sfreiburg.movietracker

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
