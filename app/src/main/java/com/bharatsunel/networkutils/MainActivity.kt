package com.bharatsunel.networkutils

import android.net.Network
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bharatsunel.networkutils.ui.theme.NetworkUtilsTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init network lib
        NetworkUtils.init(this)
        setContent {
            NetworkUtilsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent("there") {
                        Log.d(
                            "MainActivity",
                            "Has Wifi: ${NetworkUtils.hasWifiNetwork}"
                        )
                    }
                }
            }
        }

        NetworkUtils.observeDefaultNetwork(object : NetworkObserver {
            override fun onLost(network: Network) {
                Log.d(TAG, "onLost: $network")
            }

            override fun onNetworkChanged(network: Network, networkType: NetworkType) {
                Log.d(TAG, "onNetworkChanged: $network type: $networkType")
            }
        })
    }
}

@Composable
fun MainContent(name: String, modifier: Modifier = Modifier, callback: () -> Unit) {
    Box(modifier = modifier) {
        Column(
            modifier = modifier
                .padding(all = 16.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Hello $name!",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(all = 16.dp)
            )
            OutlinedButton(
                onClick = {
                    callback()
                }
            ) {
                Text(text = "Check Network Connectivity")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkUtilsTheme {
        MainContent("Android") {

        }
    }
}