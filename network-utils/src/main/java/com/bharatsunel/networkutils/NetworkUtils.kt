package com.bharatsunel.networkutils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
object NetworkUtils : InternetReachability {

    private var networkObserver: NetworkObserver? = null
    private val networkState = NetworkState()
    private var context: Context? = null

    val hasNetwork =
        networkState.isDefaultNetworkWifi || networkState.isDefaultNetworkCellular || networkState.isDefaultNetworkUnmetered
    val hasWifiNetwork = networkState.isDefaultNetworkWifi
    val hasCellularNetwork = networkState.isDefaultNetworkCellular
    val hasEthernetNetwork = networkState.isDefaultNetworkEthernet

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            networkState.setDefaultNetwork(network, networkCapabilities)
        }

        override fun onLost(network: Network) {
            networkState.setDefaultNetwork(null, null)
        }
    }

    fun init(context: Context) {
        this.context = context
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    fun observeDefaultNetwork(observer: NetworkObserver) {
        networkObserver = observer
    }

    override fun hasInternet(): Boolean {
        if (!hasNetwork) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverWifi(): Boolean {
        if (!hasWifiNetwork) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverCellular(): Boolean {
        if (!hasCellularNetwork) return false
        TODO("Not yet implemented")
    }

    override fun hasInternetOverEthernet(): Boolean {
        if (!hasEthernetNetwork) return false
        TODO("Not yet implemented")
    }

}