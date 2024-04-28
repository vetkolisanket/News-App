package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.base.GlobalTopBar
import com.example.newsapp.ui.base.NewsNavHost
import com.example.newsapp.ui.base.rememberNewsAppState
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appState = rememberNewsAppState(navController = navController)

            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        GlobalTopBar(
                            title = appState.showScreenTitle,
                            shouldShowBackIcon = appState.shouldShowBackIcon,
                            onBackClick = navController::popBackStack
                        )
                    }
                ) { padding ->
                    Column (
                        modifier = Modifier
                            .padding(padding)
                    ) {
                        NewsNavHost(navController = navController)
                    }

                }
            }
        }
    }
}