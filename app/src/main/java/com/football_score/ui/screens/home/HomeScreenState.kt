package com.football_score.ui.screens.home


sealed class HomeScreenState() {
    object Empty : HomeScreenState()
    object Loading : HomeScreenState()
    class Success(val data: MatchResponse) : HomeScreenState()
    class Error(val message: String) : HomeScreenState()
}
