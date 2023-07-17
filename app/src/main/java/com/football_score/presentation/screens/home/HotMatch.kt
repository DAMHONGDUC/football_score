package com.football_score.presentation.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.football_score.domain.model.LeagueTeam
import com.football_score.domain.model.Match
import com.football_score.domain.model.response.ViewModelState
import com.football_score.presentation.components.HotMatchCard

@Composable
fun HotMatch(homeViewModel: HomeViewModel, listLeagueTeam: List<LeagueTeam>) {

    val (selectedTeam, setSelectedTeam) = remember { mutableStateOf(listLeagueTeam[0]) }
    val hotMatches = homeViewModel.hotMatches.collectAsState().value

    LaunchedEffect(selectedTeam)
    {
        Log.d("DEBUG_HOME_SCREEN", selectedTeam.team.id.toString())
        homeViewModel.getHotMatches(selectedTeam.team.id)
    }

    Column() {
        Text(
            text = "Hot Match",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        if (listLeagueTeam.isEmpty()) {
            Text(text = "No League Team", modifier = Modifier.padding(10.dp))
        } else {
            ExposedDropdownLeagueTeam(
                listLeagueTeam = listLeagueTeam,
                selectedTeam = selectedTeam,
                setSelectedTeam = setSelectedTeam
            )
            when (hotMatches) {
                is ViewModelState.Empty -> Text(text = "No hotMatches data available")
                is ViewModelState.Loading -> Text(text = "hotMatches Loading...")
                is ViewModelState.Success -> ListHotMatches(hotMatches = hotMatches.data.response)
                is ViewModelState.Error -> Text(text = hotMatches.message)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExposedDropdownLeagueTeam(
    listLeagueTeam: List<LeagueTeam>,
    selectedTeam: LeagueTeam,
    setSelectedTeam: (LeagueTeam) -> Unit
) {
    val context = LocalContext.current
    val dropdownWidth = 250.dp;
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
    ) {

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            Row(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.onSecondary,
                        shape = RoundedCornerShape(dropdownWidth / 2)
                    )
                    .width(dropdownWidth)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                AsyncImage(
                    model = selectedTeam.team.logo,
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .padding(PaddingValues(start = 6.dp))
                )
                Text(text = selectedTeam.team.name, color = MaterialTheme.colors.background)
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Trailing icon for exposed dropdown menu",
                    Modifier
                        .rotate(
                            if (expanded)
                                180f
                            else
                                360f
                        ),
                    tint = MaterialTheme.colors.background,

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
                            setSelectedTeam(item)
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
fun ListHotMatches(hotMatches: List<Match>) {
    Column(
        Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        hotMatches.forEach { item ->
            HotMatchCard(match = item)
        }
    }
}