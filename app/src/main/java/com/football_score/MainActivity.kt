package com.football_score

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.football_score.constant.AppFontSize
import com.football_score.data.remote.model.*
import com.football_score.ui.theme.Football_scoreTheme
import com.football_score.viewmodel.LiveMatchViewModel
import com.football_score.viewmodel.state.MatchState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Football_scoreTheme {
                Column(modifier = Modifier.padding(10.dp)) {
                    Header()
                    FetchData()
                }
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
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Autorenew,
                contentDescription = "Autorenew Icon",
                modifier = Modifier.size(24.dp)
            )
        }
        Text(text = "Live Scores", fontSize = AppFontSize.PageTitle)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.DarkMode,
                contentDescription = "Mode Icon",
                modifier = Modifier.size(24.dp)
            )
        }

    }
}

@Composable
fun FetchData(liveMatchViewModel: LiveMatchViewModel = viewModel()) {
    when (val state = liveMatchViewModel.liveMatchState.collectAsState().value) {
        is MatchState.Empty -> Text(text = "No data available")
        is MatchState.Loading -> Text(text = "Loading...")
        is MatchState.Success -> LiveMatch(listLiveMatch = state.data.response)
        is MatchState.Error -> Text(text = state.message)
    }
}

@Composable
fun ClubItem(team: Team) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = team.logo,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = team.name,fontSize = AppFontSize.ListItemTitle)
    }
}

@Composable
fun MatchInfo(goals: Goals, status: Status) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(text = goals.home.toString(),fontSize = AppFontSize.ListItemTitle)
            Text(text = " - ",fontSize = AppFontSize.ListItemTitle)
            Text(text = goals.away.toString(),fontSize = AppFontSize.ListItemTitle)
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = status.elapsed.toString() + "'", fontSize = AppFontSize.ListItemTitle)
    }
}

@Composable
fun LiveMatchItem(match: Match) {
    Card(
        shape = RoundedCornerShape(30.dp), modifier = Modifier
            .width(300.dp)
            .height(130.dp)
            .background(Color.White)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = match.league.name, fontSize = AppFontSize.ListTitle)
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
fun LiveMatch(listLiveMatch: List<Match>) {
    Column(modifier = Modifier.padding(15.dp)) {
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Live Now",
            fontSize = AppFontSize.SectionTitle
        )
        Spacer(modifier = Modifier.height(10.dp))

        if (listLiveMatch.isEmpty()) {
            Text(text = "No Live Match", modifier = Modifier.padding(10.dp))
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
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

