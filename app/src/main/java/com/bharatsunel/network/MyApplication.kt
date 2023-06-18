package com.bharatsunel.network

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.bharatsunel.network.NetworkUtils

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkUtils.init(this)
    }
}