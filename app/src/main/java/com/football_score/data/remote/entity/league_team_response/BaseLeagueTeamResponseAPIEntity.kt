package com.football_score.data.remote.entity.league_team_response

import com.football_score.data.remote.entity.PagingAPIEntity
import com.football_score.data.remote.entity.ParametersAPIEntity
import com.football_score.domain.model.league_team_response.LeagueTeamResponse

data class BaseLeagueTeamResponseAPIEntity(
    val get: String,
    val parameters: ParametersAPIEntity,
    val errors: List<Any>,
    val results: Int,
    val paging: PagingAPIEntity,
    val response: List<TeamResponseAPIEntity>,
)

fun BaseLeagueTeamResponseAPIEntity.toDomain() = LeagueTeamResponse(
    response = this.response.map { it.toDomain() },
    results = this.results,
    errors = this.errors
)

