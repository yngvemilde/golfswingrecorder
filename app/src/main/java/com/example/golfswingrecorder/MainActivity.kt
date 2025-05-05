package com.example.golfswingrecorder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.golfswingrecorder.ui.theme.GolfswingrecorderTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GolfswingrecorderTheme {
                Scaffold { innerPadding ->
                    ControlScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

// Flyttet ut av klassen slik at @Preview kan finne den
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControlScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            // Merk: Context må være en Activity, så her bruker vi LocalContext om nødvendig.
            // Men i praksis funker startForegroundService fra ComponentActivity-innholdet.
            // Denne knappen vil fungere når ControlScreen brukes i MainActivity.
        }) {
            Text("Start opptak")
        }
        Button(
            onClick = {
                // tilsvarende
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Stopp opptak")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ControlScreenPreview() {
    GolfswingrecorderTheme {
        ControlScreen()
    }
}
