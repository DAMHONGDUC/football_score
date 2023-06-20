package com.football_score.domain.model.league_team

import com.football_score.domain.model.LeagueTeam

data class LeagueTeamResponse(
    val response: List<LeagueTeam>,
    val results: Int,
    val errors: List<Any>,
)