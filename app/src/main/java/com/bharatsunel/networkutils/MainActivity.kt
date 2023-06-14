package com.bharatsunel.networkutils

import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkUtilsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("there")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
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
                onClick = { }
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
        Greeting("Android")
    }
}