package com.football_score.domain.use_case

import com.football_score.domain.use_case.match.GetHotMatchUseCase
import com.football_score.domain.use_case.match.GetAllLiveMatchUseCase
import com.football_score.domain.use_case.team.GetLeagueTeamUseCase

data class UseCase(
    val getAllLiveMatch: GetAllLiveMatchUseCase,

    val getHotMatches: GetHotMatchUseCase,

    val getLeagueTeam: GetLeagueTeamUseCase
)

