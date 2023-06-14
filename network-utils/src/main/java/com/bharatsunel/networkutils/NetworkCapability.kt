package com.bharatsunel.networkutils

import android.content.Context

interface NetworkCapability {
    fun hasAnyNetworkCapability(context: Context): Boolean
    fun hasWifiCapability(context: Context): Boolean
    fun hasCellularCapability(context: Context): Boolean
    fun hasEthernetCapability(context: Context): Boolean
}