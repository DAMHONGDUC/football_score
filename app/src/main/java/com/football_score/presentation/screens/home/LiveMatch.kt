package com.football_score.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.football_score.domain.model.Match
import com.football_score.presentation.components.LiveMatchCard

@Composable
fun LiveMatch(listLiveMatch: List<Match>) {
    Column() {
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