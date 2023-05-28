package com.football_score.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val state = homeViewModel.liveMatchState.collectAsState().value

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {
        Column(modifier = Modifier.padding(20.dp)) {
            Header()
            when (state) {
                is HomeScreenState.Empty -> Text(text = "No data available")
                is HomeScreenState.Loading -> Text(text = "Loading...")
                is HomeScreenState.Success -> LiveMatch(listLiveMatch = state.data.response)
                is HomeScreenState.Error -> Text(text = state.message)
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
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
            IconButton(onClick = { /*TODO*/ }) {
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
fun ClubItem(team: com.football_score.domain.model.Team) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(80.dp)) {
        AsyncImage(
            model = team.logo,
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height((50.dp))
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = team.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.background
        )
    }
}

@Composable
fun MatchInfo(goals: com.football_score.domain.model.Goals, status: com.football_score.domain.model.Status) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(
                text = goals.home.toString(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.background
            )
            Text(
                text = " - ",
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.background
            )
            Text(
                text = goals.away.toString(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.background
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = status.elapsed.toString() + "'",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.background
        )
    }
}

@Composable
fun LiveMatchItem(match: com.football_score.domain.model.Match) {
    Card(
        shape = RoundedCornerShape(20.dp), modifier = Modifier
            .width(300.dp)
            .height(200.dp),
        backgroundColor = MaterialTheme.colors.onSecondary
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = match.league.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.background
            )
            Text(
                text = match.league.round,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.background
            )
            Text(
                text = match.league.country,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.background
            )
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ClubItem(team = match.teams.home)
                MatchInfo(goals = match.goals, status = match.fixture.status)
                ClubItem(team = match.teams.away)
            }
        }
    }
}

@Composable
fun LiveMatch(listLiveMatch: List<com.football_score.domain.model.Match>) {
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
                    LiveMatchItem(match = listLiveMatch[it])
                }
            }


        }
    }
}