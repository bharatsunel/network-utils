package com.bharatsunel.networkutils

import android.net.Network

interface NetworkObserver {
    fun onLost(network: Network)
    fun onNetworkChanged(network: Network, networkType: NetworkType)
}