package com.football_score.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.football_score.App
import com.football_score.domain.model.LeagueTeam
import com.football_score.domain.model.Match
import com.football_score.domain.model.response.ViewModelState
import com.football_score.presentation.components.AppHeader
import com.football_score.presentation.components.LiveMatchCard


@Composable
fun HomeScreen(
    navController: NavHostController,
    app: App,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val liveMatches = homeViewModel.liveMatches.collectAsState().value
    val leagueTeams = homeViewModel.leagueTeam.collectAsState().value

    val (isReload, setIsReload) = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isReload) {
        if (isReload) {
            homeViewModel.getAllLiveMatch();
            homeViewModel.getLeagueTeam();

            setIsReload(false);
        }
    }

    Scaffold(
        topBar = { AppHeader(app = app, setIsReload = setIsReload) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(MaterialTheme.colors.background)
            ) {

                when (liveMatches) {
                    is ViewModelState.Empty -> Text(text = "No liveMatches data available")
                    is ViewModelState.Loading -> Text(text = "liveMatches Loading...")
                    is ViewModelState.Success -> LiveMatch(listLiveMatch = liveMatches.data.response)
                    is ViewModelState.Error -> Text(text = liveMatches.message)
                }

                Spacer(modifier = Modifier.height(20.dp))

                when (leagueTeams) {
                    is ViewModelState.Empty -> Text(text = "No leagueTeams data available")
                    is ViewModelState.Loading -> Text(text = "leagueTeams Loading...")
                    is ViewModelState.Success -> HotMatch(listLeagueTeam = leagueTeams.data.response)
                    is ViewModelState.Error -> Text(text = leagueTeams.message)
                }
            }
        }
    )
}

@Composable
fun LiveMatch(listLiveMatch: List<Match>) {
    Column() {
        Text(
            text = "Live Match",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(10.dp))

        if (listLiveMatch.isEmpty()) {
            Text(text = "No Live Match", modifier = Modifier.padding(10.dp))
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            )
            {
                items(listLiveMatch.size)
                {
                    LiveMatchCard(match = listLiveMatch[it])
                }
            }
        }
    }
}

@Composable
fun HotMatch(listLeagueTeam: List<LeagueTeam>) {
    Column() {
        Text(
            text = "Hot Match",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )

        if (listLeagueTeam.isEmpty()) {
            Text(text = "No League Team", modifier = Modifier.padding(10.dp))
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            )
            {
                items(listLeagueTeam.size)
                {
                    Text(text = listLeagueTeam[it].team.name)
                }
            }
        }
    }
}