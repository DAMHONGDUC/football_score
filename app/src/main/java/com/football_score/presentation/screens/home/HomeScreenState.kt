package com.football_score.presentation.screens.home

import com.football_score.domain.model.response.LeagueTeamResponse
import com.football_score.domain.model.response.MatchResponse


sealed class HomeScreenState<out T>() {
    object Empty : HomeScreenState<Nothing>()
    object Loading : HomeScreenState<Nothing>()
    class Success<out T>(val data: T) : HomeScreenState<T>()
    class Error(val message: String) : HomeScreenState<Nothing>()
}