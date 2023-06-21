package com.football_score.presentation.screens.home

import com.football_score.domain.model.response.LeagueTeamResponse
import com.football_score.domain.model.response.MatchResponse


sealed class HomeScreenState() {
    object Empty : HomeScreenState()
    object Loading : HomeScreenState()
    class Success(val matchResponse: MatchResponse, val leagueTeamResponse: LeagueTeamResponse) : HomeScreenState()
    class Error(val message: String) : HomeScreenState()
}
