package com.example.newsapp.ui.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newsapp.R

/**
 * The NewsAppState class manages navigation-related state in the News App.
 * It determines whether to display a back icon in the app bar and provides
 * the title of the current screen. The rememberNewsAppState function
 * initializes and retains the app state across recompositions.
 * */
@Composable
fun rememberNewsAppState(
    navController: NavHostController
): NewsAppState {
    return remember(navController) {
        NewsAppState(navController)
    }
}

class NewsAppState(private val navController: NavHostController) {

    private val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val shouldShowBackIcon: Boolean
        @Composable get() = when (currentDestination?.route) {
            Route.Home.name -> false
            else -> true
        }

    val showScreenTitle: String
        @Composable get() = when (currentDestination?.route) {
            Route.Home.name -> stringResource(id = R.string.app_name)
            else -> ""
        }

}