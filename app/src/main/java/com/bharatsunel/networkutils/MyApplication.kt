package com.bharatsunel.networkutils

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkUtils.init(this)
    }
}