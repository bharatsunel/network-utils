package com.bharatsunel.networkutils

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bharatsunel.networkutils.ui.theme.NetworkUtilsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<MainViewModel>()

        setContent {
            NetworkUtilsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent(viewModel, callbackNetwork = {
                        CoroutineScope(Dispatchers.IO).launch {
                            Log.d(
                                "MainActivity",
                                "Has Network: ${NetworkUtils.hasNetwork()}"
                            )
                            viewModel.defaultNetwork.value = "Has Network: ${NetworkUtils.hasNetwork()}"
                        }
                    }, callbackInternet = {
                        CoroutineScope(Dispatchers.IO).launch {
                            Log.d(
                                "MainActivity",
                                "Has Internet: ${NetworkUtils.hasInternet()}"
                            )
                            viewModel.defaultNetwork.value = "Has Internet: ${NetworkUtils.hasInternet()}"
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel, modifier: Modifier = Modifier, callbackNetwork: () -> Unit, callbackInternet: () -> Unit) {
    val defaultNetwork = viewModel.defaultNetwork.collectAsState(initial = null)
    Box(modifier = modifier) {
        Column(
            modifier = modifier
                .padding(all = 16.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Result: ${defaultNetwork.value}!",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(all = 16.dp)
            )
            OutlinedButton(
                onClick = {
                    callbackNetwork()
                }
            ) {
                Text(text = "Check Network Connectivity")
            }
            OutlinedButton(
                onClick = {
                    callbackInternet()
                }
            ) {
                Text(text = "Check Internet Reachability")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkUtilsTheme {
//        MainContent("Android") {
//
//        }
    }
}