package com.football_score.navigation

sealed class Screen(val route: String)
{
    object Home: Screen( route = "home")
}
