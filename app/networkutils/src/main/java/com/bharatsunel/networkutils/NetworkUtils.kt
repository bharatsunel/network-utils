package com.bharatsunel.networkutils

import android.content.Context

object NetworkUtils: NetworkConnector, InternetConnector {
    override fun hasAnyNetwork(context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasWifi(context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasCellular(context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasEthernet(context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasInternet(context: Context): Boolean {
        if (!hasAnyNetwork(context)) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverWifi(context: Context): Boolean {
        if (!hasWifi(context)) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverEthernet(context: Context): Boolean {
        if (!hasEthernet(context)) return false
        TODO("Not yet implemented")
    }

}