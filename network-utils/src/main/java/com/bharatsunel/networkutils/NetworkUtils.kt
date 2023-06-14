package com.bharatsunel.networkutils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkUtils : NetworkConnector, InternetConnector {

    private fun getNetworkCapabilities(context: Context): NetworkCapabilities? {
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        val currentNetwork = connectivityManager.activeNetwork
        return connectivityManager.getNetworkCapabilities(currentNetwork)
    }

    override fun hasAnyNetwork(context: Context): Boolean {
        val caps = getNetworkCapabilities(context) ?: return false
        return when {
            caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    override fun hasWifi(context: Context): Boolean {
        getNetworkCapabilities(context)?.let {
            return it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
        return false
    }

    override fun hasCellular(context: Context): Boolean {
        getNetworkCapabilities(context)?.let {
            return it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
        return false
    }

    override fun hasEthernet(context: Context): Boolean {
        getNetworkCapabilities(context)?.let {
            return it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        }
        return false
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