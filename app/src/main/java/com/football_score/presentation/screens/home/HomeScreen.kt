package com.football_score.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.football_score.App
import com.football_score.domain.model.*


@Composable
fun HomeScreen(
    navController: NavHostController,
    app: App,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState = homeViewModel.state.collectAsState().value

    LaunchedEffect(true) {
        homeViewModel.getData();
    }

    Scaffold(
        topBar = { Header(app = app) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(MaterialTheme.colors.background)
            ) {
                when (homeState) {
                    is HomeScreenState.Empty -> Text(text = "No data available")
                    is HomeScreenState.Loading -> Text(text = "Loading...")
                    is HomeScreenState.Success -> Body(
                        listLiveMatch = homeState.matchResponse.response,
                        listLeagueTeam = homeState.leagueTeamResponse.response
                    )
                    is HomeScreenState.Error -> Text(text = homeState.message)
                }
            }
        }
    )
}

@Composable
fun Header(app: App) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Live Scores",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground
        )
        Row()
        {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Autorenew,
                    contentDescription = "Autorenew Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { app.changeTheme() }) {
                Icon(
                    imageVector = Icons.Filled.DarkMode,
                    contentDescription = "Mode Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun Body(listLiveMatch: List<Match>, listLeagueTeam: List<LeagueTeam>) {
    LiveMatch(listLiveMatch = listLiveMatch)
    HotMatch()
}