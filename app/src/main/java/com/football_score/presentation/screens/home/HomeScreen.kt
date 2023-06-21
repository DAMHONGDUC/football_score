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


@Composable
fun HomeScreen(
    navController: NavHostController,
    app: App,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val liveMatches = homeViewModel.liveMatches.collectAsState().value

    LaunchedEffect(true) {
        homeViewModel.getAllLiveMatch();
    }

    Scaffold(
        topBar = { Header(app = app) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(MaterialTheme.colors.background)
            ) {

                when (liveMatches) {
                    is HomeScreenState.Empty -> Text(text = "No data available")
                    is HomeScreenState.Loading -> Text(text = "Loading...")
                    is HomeScreenState.Success -> LiveMatch(listLiveMatch = liveMatches.data.response)
                    is HomeScreenState.Error -> Text(text = liveMatches.message)
                    else -> {}
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