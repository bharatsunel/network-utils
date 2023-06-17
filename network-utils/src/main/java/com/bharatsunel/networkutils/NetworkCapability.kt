package com.bharatsunel.networkutils

import android.content.Context

interface NetworkCapability {
    fun hasAnyNetworkCapability(): Boolean
    fun hasWifiCapability(): Boolean
    fun hasCellularCapability(): Boolean
    fun hasEthernetCapability(): Boolean
}