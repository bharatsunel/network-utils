package com.bharatsunel.networkutils

import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_NOT_METERED
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_ETHERNET
import android.net.NetworkCapabilities.TRANSPORT_WIFI

class NetworkState {
    private var defaultNetwork: Network? = null
    private var defaultCapabilities: NetworkCapabilities? = null
    fun setDefaultNetwork(network: Network?, caps: NetworkCapabilities?) = synchronized(this) {
        defaultNetwork = network
        defaultCapabilities = caps
    }

    val isDefaultNetworkWifi
        get() = synchronized(this) {
            defaultCapabilities?.hasTransport(TRANSPORT_WIFI) ?: false
        }
    val isDefaultNetworkCellular
        get() = synchronized(this) {
            defaultCapabilities?.hasTransport(TRANSPORT_CELLULAR) ?: false
        }

    val isDefaultNetworkEthernet
        get() = synchronized(this) {
            defaultCapabilities?.hasTransport(TRANSPORT_ETHERNET) ?: false
        }

    val isDefaultNetworkUnmetered
        get() = synchronized(this) {
            defaultCapabilities?.hasCapability(NET_CAPABILITY_NOT_METERED) ?: false
        }
}