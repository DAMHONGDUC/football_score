package com.football_score.presentation.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.football_score.App
import com.football_score.domain.model.LeagueTeam
import com.football_score.domain.model.Match
import com.football_score.domain.model.response.ViewModelState
import com.football_score.presentation.components.AppHeader
import com.football_score.presentation.components.LiveMatchCard


@Composable
fun HomeScreen(
    navController: NavHostController,
    app: App,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val liveMatches = homeViewModel.liveMatches.collectAsState().value
    val leagueTeams = homeViewModel.leagueTeam.collectAsState().value

    val (isReload, setIsReload) = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isReload) {
        if (isReload) {
            homeViewModel.getAllLiveMatch();
            //homeViewModel.getLeagueTeam();

            setIsReload(false);
        }
    }

    Scaffold(
        topBar = { AppHeader(app = app, setIsReload = setIsReload) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(MaterialTheme.colors.background)
            ) {

                when (liveMatches) {
                    is ViewModelState.Empty -> Text(text = "No liveMatches data available")
                    is ViewModelState.Loading -> Text(text = "liveMatches Loading...")
                    is ViewModelState.Success -> LiveMatch(listLiveMatch = liveMatches.data.response)
                    is ViewModelState.Error -> Text(text = liveMatches.message)
                }

                Spacer(modifier = Modifier.height(20.dp))

                when (leagueTeams) {
                    is ViewModelState.Empty -> Text(text = "No leagueTeams data available")
                    is ViewModelState.Loading -> Text(text = "leagueTeams Loading...")
                    is ViewModelState.Success -> HotMatch(listLeagueTeam = leagueTeams.data.response)
                    is ViewModelState.Error -> Text(text = leagueTeams.message)
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExposedDropdownLeagueTeam(listLeagueTeam: List<LeagueTeam>) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(listLeagueTeam[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            Row() {
                TextField(
                    value = selectedItem.team.name,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    leadingIcon = {
                        AsyncImage(
                            model = selectedItem.team.logo,
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp))
                    },
                )
            }

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listLeagueTeam.forEach { item ->
                    DropdownMenuItem(
                        content = {
                            Row()
                            {
                                AsyncImage(
                                    model = item.team.logo,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(20.dp)
                                        .height((20.dp))
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                Text(text = item.team.name)
                            }

                        },
                        onClick = {
                            selectedItem = item
                            expanded = false
                            Toast.makeText(context, item.team.name, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

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
                    LiveMatchCard(match = listLiveMatch[it])
                }
            }
        }
    }
}

@Composable
fun HotMatch(listLeagueTeam: List<LeagueTeam>) {
    Column() {
        Text(
            text = "Hot Match",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )

        if (listLeagueTeam.isEmpty()) {
            Text(text = "No League Team", modifier = Modifier.padding(10.dp))
        } else {
            ExposedDropdownLeagueTeam(listLeagueTeam = listLeagueTeam)
        }
    }
}