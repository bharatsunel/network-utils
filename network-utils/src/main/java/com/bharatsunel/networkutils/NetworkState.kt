package com.bharatsunel.networkutils

import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_NOT_METERED
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_ETHERNET
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import android.telephony.TelephonyManager

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
    var cellNetworkType: Int = TelephonyManager.NETWORK_TYPE_UNKNOWN
        get() = synchronized(this) { field }
        set(t) = synchronized(this) { field = t }
    private val cellModifier: Float
        get() = synchronized(this) {
            when (cellNetworkType) {
                TelephonyManager.NETWORK_TYPE_LTE or TelephonyManager.NETWORK_TYPE_HSPAP -> 4f
                TelephonyManager.NETWORK_TYPE_EDGE or TelephonyManager.NETWORK_TYPE_GPRS -> 1 / 2f
                else -> 1f
            }
        }
//    val prefetchCacheSize: Int
//        get() = when {
//            isDefaultNetworkWifi -> MAX_PREFETCH_CACHE
//            isDefaultNetworkCellular -> (DEFAULT_PREFETCH_CACHE * cellModifier).toInt()
//            else -> DEFAULT_PREFETCH_CACHE
//        }
}