package com.bharatsunel.networkutils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


object NetworkUtils : DefaultLifecycleObserver {

    private val networkState = NetworkState()
    private var connectivityManager: ConnectivityManager? = null
    private var networkCallback: ConnectivityManager.NetworkCallback? = null
    fun init(context: Context) {
        connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        networkCallback = object :
            ConnectivityManager.NetworkCallback() {
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
        networkCallback?.let {
            connectivityManager?.registerDefaultNetworkCallback(it)
        }
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    fun isDefaultNetworkCellular() = networkState.isDefaultNetworkCellular
    fun isDefaultNetworkEthernet() = networkState.isDefaultNetworkEthernet

    fun hasNetwork() =
        networkState.isDefaultNetworkWifi || networkState.isDefaultNetworkCellular || networkState.isDefaultNetworkUnmetered

    fun isDefaultNetworkWifi() = networkState.isDefaultNetworkWifi


    suspend fun hasInternet(): Boolean {
        if (!hasNetwork()) return false
        return withContext(Dispatchers.IO) {
            try {
                val connection = URL("https://www.google.com").openConnection() as HttpURLConnection
                connection.setRequestProperty("User-Agent", "ConnectionTest")
                connection.setRequestProperty("Connection", "close")
                connection.connectTimeout = 1000
                connection.connect()
                Log.d("NetworkUtils", "hasInternetConnected: ${(connection.responseCode == 200)}")
                return@withContext (connection.responseCode == 200)
            } catch (e: IOException) {
                Log.e("NetworkUtils", "Error checking internet connection", e)
                false
            }
        }
    }

    private fun release() {
        connectivityManager?.unregisterNetworkCallback(networkCallback!!)
        connectivityManager = null
        networkCallback = null
        ProcessLifecycleOwner.get().lifecycle.removeObserver(this)
    }

    override fun onStop(owner: LifecycleOwner) {
        release()
    }
}