package com.bharatsunel.networkutils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkUtils : NetworkCapability, InternetReachability {

    private fun getNetworkCapabilities(context: Context): NetworkCapabilities? {
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        val currentNetwork = connectivityManager.activeNetwork
        return connectivityManager.getNetworkCapabilities(currentNetwork)
    }

    override fun hasAnyNetworkCapability(context: Context): Boolean {
        val caps = getNetworkCapabilities(context) ?: return false
        return when {
            caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    override fun hasWifiCapability(context: Context): Boolean {
        getNetworkCapabilities(context)?.let {
            return it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
        return false
    }

    override fun hasCellularCapability(context: Context): Boolean {
        getNetworkCapabilities(context)?.let {
            return it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
        return false
    }

    override fun hasEthernetCapability(context: Context): Boolean {
        getNetworkCapabilities(context)?.let {
            return it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        }
        return false
    }

    override fun hasInternet(context: Context): Boolean {
        if (!hasAnyNetworkCapability(context)) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverWifi(context: Context): Boolean {
        if (!hasWifiCapability(context)) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverCellular(context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasInternetOverEthernet(context: Context): Boolean {
        if (!hasEthernetCapability(context)) return false
        TODO("Not yet implemented")
    }

}