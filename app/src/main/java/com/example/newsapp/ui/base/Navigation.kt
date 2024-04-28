package com.example.newsapp.ui.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.ui.home.HomeScreenRoute

sealed class Route(val name: String) {

    object Home: Route("home")
    object TopHeadline: Route("topHeadline")

}

@Composable
fun NewsNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Route.Home.name) {
        composable(Route.Home.name) {
            HomeScreenRoute(navController = navController)
        }
    }

}
