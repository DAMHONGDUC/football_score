package com.football_score.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.football_score.domain.model.Goals
import com.football_score.domain.model.Match
import com.football_score.domain.model.Status
import com.football_score.domain.model.Team

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
                    LiveMatchItem(match = listLiveMatch[it])
                }
            }


        }
    }
}

@Composable
fun ClubItem(team: Team) {
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
fun MatchInfo(
    goals: Goals,
    status: Status
) {
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

