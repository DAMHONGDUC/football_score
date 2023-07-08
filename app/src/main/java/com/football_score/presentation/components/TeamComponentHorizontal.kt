package com.football_score.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.football_score.domain.model.Team

@Composable
fun TeamComponentHorizontal(team: Team, reverse: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(200.dp)) {
        if (!reverse) {
            Text(text = team.name, color = MaterialTheme.colors.background)
            AsyncImage(
                model = team.logo,
                contentDescription = null,
                modifier = Modifier
                    .width(40.dp)
                    .height((40.dp))
            )
        } else {

            AsyncImage(
                model = team.logo,
                contentDescription = null,
                modifier = Modifier
                    .width(40.dp)
                    .height((40.dp))
            )
            Text(text = team.name, color = MaterialTheme.colors.background)
        }
    }

}