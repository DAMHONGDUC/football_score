package com.football_score.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.football_score.domain.model.LeagueTeam

@Composable
fun HotMatch(homeViewModel: HomeViewModel ,listLeagueTeam: List<LeagueTeam>) {

    LaunchedEffect(true)
    {
        //homeViewModel.getLeagueTeam()
    }


    Column() {
        Text(
            text = "Hot Match",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
    }
}