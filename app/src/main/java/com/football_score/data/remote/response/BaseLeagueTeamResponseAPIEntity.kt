package com.football_score.data.remote.response

import com.football_score.data.remote.entity.PagingAPIEntity
import com.football_score.data.remote.entity.ParametersAPIEntity
import com.football_score.domain.model.response.LeagueTeamResponse

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

