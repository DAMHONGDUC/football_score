package com.football_score.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.football_score.domain.model.Match

@Composable
fun HotMatchCard(match: Match) {
    val ClubIConSize = 35.dp;

    Row(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.onSecondary,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1.5F),
            horizontalArrangement = Arrangement.Start
        )
        {
            Text(
                text = match.teams.home.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.background,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = match.teams.home.logo,
                contentDescription = null,
                modifier = Modifier
                    .width(ClubIConSize)
                    .height(ClubIConSize)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 7.dp, end = 7.dp)
            ) {
                Row() {
                    Text(
                        text = match.goals.home.toString(),
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
                        text = match.goals.away.toString(),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.background
                    )
                }

                Text(
                    text = "30 OCT",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.background,
                )

            }

            AsyncImage(
                model = match.teams.away.logo,
                contentDescription = null,
                modifier = Modifier
                    .width(ClubIConSize)
                    .height(ClubIConSize)
            )
        }

        Row(
            modifier = Modifier
                .weight(1.5F),
            horizontalArrangement = Arrangement.End
        )
        {
            Text(
                text = match.teams.away.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.background
            )
        }

    }
}