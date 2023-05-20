package com.football_score

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.football_score.constant.AppColor
import com.football_score.constant.AppFontSize
import com.football_score.data.remote.model.*
import com.football_score.ui.theme.Football_scoreTheme
import com.football_score.utils.Helper
import com.football_score.viewmodel.LiveMatchViewModel
import com.football_score.viewmodel.state.MatchState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Football_scoreTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    Column(modifier = Modifier.padding(20.dp)) {
        Header()
        FetchData()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Live Scores", fontSize = AppFontSize.PageTitle)
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
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(100.dp)) {
        AsyncImage(
            model = team.logo,
            contentDescription = null,
            modifier = Modifier
                .width(40.dp)
                .height((40.dp))
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = team.name,
            fontSize = AppFontSize.TeamItemTitle,
            color = AppColor.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MatchInfo(goals: Goals, status: Status) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(
                text = goals.home.toString(),
                fontSize = AppFontSize.ListItemTitle,
                color = AppColor.White
            )
            Text(text = " - ", fontSize = AppFontSize.ListItemTitle, color = AppColor.White)
            Text(
                text = goals.away.toString(),
                fontSize = AppFontSize.ListItemTitle,
                color = AppColor.White
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = status.elapsed.toString() + "'",
            fontSize = AppFontSize.ListItemTitle,
            color = AppColor.White
        )
    }
}

@Composable
fun LiveMatchItem(match: Match) {
    Card(
        shape = RoundedCornerShape(30.dp), modifier = Modifier
            .width(300.dp)
            .height(130.dp),
        backgroundColor = AppColor.Secondary
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = match.league.name, fontSize = AppFontSize.ListTitle, color = AppColor.White)
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
fun DropDown(listLeague: HashMap<Int, League>) {
    val contextForToast = LocalContext.current.applicationContext
    val currentLeague = listLeague[481]

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }


    Box(
        contentAlignment = Alignment.Center
    ) {
        // 3 vertical dots icon
        IconButton(onClick = {
            expanded = true
        }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (currentLeague != null) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(currentLeague.flag)
                            .decoderFactory(SvgDecoder.Factory())
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height((20.dp))
                    )



                    Column() {
                        Text(
                            text = currentLeague.name,
                            fontSize = AppFontSize.ListTitle,
                            color = AppColor.Black
                        )
                        Text(
                            text = currentLeague.country,
                            fontSize = AppFontSize.ListTitle,
                            color = AppColor.Black
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ExpandMore,
                            contentDescription = "Autorenew Icon",
                        )
                    }
                }
            }
        }

        MaterialTheme(
            colors = MaterialTheme.colors.copy(surface = AppColor.Primary),
        ) {
            // drop down menu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                modifier = Modifier.height(300.dp),


                ) {
                // adding items
                for (key in listLeague.keys) {
                    val name = listLeague[key]?.name

                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                        },
                    ) {
                        if (name != null) {
                            Text(text = name)
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun LiveMatch(listLiveMatch: List<Match>) {
    Column() {
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Live Now",
            fontSize = AppFontSize.SectionTitle
        )
        Spacer(modifier = Modifier.height(10.dp))

        if (listLiveMatch.isEmpty()) {
            Text(text = "No Live Match", modifier = Modifier.padding(10.dp))
        } else {
            Column() {
                DropDown(listLeague = Helper.getListLeagues(listLiveMatch))
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
}

