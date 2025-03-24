package com.gangadhari.rsandroidtakehomechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.gangadhari.rsandroidtakehomechallenge.presentation.navigation.Navigation
import com.gangadhari.rsandroidtakehomechallenge.presentation.ui.theme.RSAndroidTakeHomeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RSAndroidTakeHomeChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation()
                }
            }
        }
    }
}

