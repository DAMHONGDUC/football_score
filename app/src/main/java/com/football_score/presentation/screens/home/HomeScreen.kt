package com.football_score.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.football_score.App
import com.football_score.domain.model.response.MatchResponse
import com.football_score.domain.model.response.ViewModelState
import com.football_score.presentation.components.AppHeader
import com.football_score.presentation.components.LiveMatchCard
import com.football_score.presentation.components.ShimmerLoading

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

                Column() {
                    Text(
                        text = "Live Match",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    when (liveMatches) {
                        is ViewModelState.Empty -> Text(text = "No liveMatches data available")
                        is ViewModelState.Loading -> LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        )
                        {
                            items(2)
                            {
                                ShimmerLoading(
                                    modifier = Modifier
                                        .width(300.dp)
                                        .height(200.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                )
                            }
                        }
                        is ViewModelState.Success -> LiveMatch(listLiveMatch = liveMatches.data.response)
                        is ViewModelState.Error -> Text(text = "somthing wrong")
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                when (leagueTeams) {
                    is ViewModelState.Empty -> Text(text = "No leagueTeams data available")
                    is ViewModelState.Loading -> Text(text = "leagueTeams Loading...")
                    is ViewModelState.Success -> HotMatch(
                        homeViewModel = homeViewModel,
                        listLeagueTeam = leagueTeams.data.response
                    )
                    is ViewModelState.Error -> Text(text = "somthing wrong")
                }
            }
        }
    )
}

