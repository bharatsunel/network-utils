package com.bharatsunel.networkutils

import android.content.Context

interface NetworkConnector {
    fun hasAnyNetwork(context: Context): Boolean
    fun hasWifi(context: Context): Boolean
    fun hasCellular(context: Context): Boolean
    fun hasEthernet(context: Context): Boolean
}