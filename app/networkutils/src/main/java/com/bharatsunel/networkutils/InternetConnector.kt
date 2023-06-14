package com.bharatsunel.networkutils

import android.content.Context

interface InternetConnector {
    fun hasInternet(context: Context): Boolean
    fun hasInternetOverWifi(context: Context): Boolean
    fun hasInternetOverEthernet(context: Context): Boolean
}