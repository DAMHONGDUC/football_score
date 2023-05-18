package com.football_score

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
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
                Column(modifier = Modifier.padding(20.dp)) {
                    StatusBar()
                    FetchData()
                }
            }
        }
    }
}

@Composable
fun FetchData(liveMatchViewModel: LiveMatchViewModel = viewModel())
{
    when (val state = liveMatchViewModel.liveMatchState.collectAsState().value)
    {
        is MatchState.Empty -> Text(text = "No data available")
        is MatchState.Loading -> Text(text = "Loading...")
        is MatchState.Success -> Text(text = "Success")
        is MatchState.Error -> Text(text = state.message)

    }
}
@Composable
fun StatusBar()
{
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Autorenew, contentDescription = "Autorenew Icon",modifier = Modifier.size(35.dp))
        }
        Text(text = "Live Scores", style = MaterialTheme.typography.h5)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.DarkMode, contentDescription = "Mode Icon",modifier = Modifier.size(35.dp))
        }

    }
}



