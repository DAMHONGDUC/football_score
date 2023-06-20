package com.football_score.domain.use_case

import com.football_score.data.remote.request.FixturesParamRequest
import com.football_score.domain.use_case.match.GetAllHotMatchUseCase
import com.football_score.domain.use_case.match.GetAllLiveMatchUseCase
import com.football_score.domain.use_case.team.GetLeagueTeamUseCase

data class UseCase(
    val getAllLiveMatch: GetAllLiveMatchUseCase,

    val getAllHotMatch: GetAllHotMatchUseCase,

    val getLeagueTeam: GetLeagueTeamUseCase
)

