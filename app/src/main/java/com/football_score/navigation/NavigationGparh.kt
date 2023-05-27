package com.football_score.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.football_score.presentation.screens.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")


@Composable
fun SetUpNavGraph(navController: NavHostController) {
    Scaffold()
    {
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(route = Screen.Home.route) { HomeScreen(navController = navController) }
        }
       // HomeScreen(navController = navController)
    }
}