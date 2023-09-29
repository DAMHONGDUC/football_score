package com.football_score.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.football_score.App
import com.football_score.presentation.screens.home.HomeScreen
import com.football_score.presentation.screens.matchDetail.MatchDetail


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")


@Composable
fun SetUpNavGraph(navController: NavHostController, app: App) {
    Scaffold()
    {
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(route = Screen.Home.route) { HomeScreen(navController = navController, app = app) }
            composable(route = Screen.MatchDetail.route) { MatchDetail(navController = navController, app = app) }
        }
    }
}