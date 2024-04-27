package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.ui.base.GlobalTopBar
import com.example.newsapp.ui.home.HomeScreen
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        GlobalTopBar(
                            title = "Home",
                            shouldShowBackIcon = false,
                            onBackClick = {}
                        )
                    }
                ) { padding ->
                    Column (
                        modifier = Modifier
                            .padding(padding)
                    ) {
                        HomeScreen()
                    }

                }
            }
        }
    }
}