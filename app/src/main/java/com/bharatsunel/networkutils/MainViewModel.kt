package com.bharatsunel.networkutils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    val defaultNetwork = MutableStateFlow<String?>(null)

}