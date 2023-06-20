package com.football_score.presentation.screens.home

import com.football_score.domain.model.match_response.MatchResponse


sealed class HomeScreenState() {
    object Empty : HomeScreenState()
    object Loading : HomeScreenState()
    class Success(val data: MatchResponse) : HomeScreenState()
    class Error(val message: String) : HomeScreenState()
}
