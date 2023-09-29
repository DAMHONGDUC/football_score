package com.football_score.navigation

sealed class Screen(val route: String)
{
    object Home: Screen( route = "home")
    object MatchDetail: Screen( route = "match_detail")
}
