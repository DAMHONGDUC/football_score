package com.football_score.presentation.screens.matchDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.football_score.App
import com.football_score.presentation.screens.home.HomeViewModel

@Composable
fun MatchDetail(
    navController: NavHostController,
    app: App,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    Scaffold(content = { padding ->
        Column() {
            Text(text = "Match Detail")
        }
    })
}