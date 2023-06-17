package com.bharatsunel.networkutils

import android.content.Context

interface InternetReachability {
    fun hasInternet(): Boolean
    fun hasInternetOverWifi(): Boolean
    fun hasInternetOverCellular(): Boolean
    fun hasInternetOverEthernet(): Boolean
}