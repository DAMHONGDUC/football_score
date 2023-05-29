package com.football_score.data.remote.entity

import com.football_score.domain.model.MatchResponse

data class MatchResponseAPIEntity(
    val errors: List<Any>,
    val `get`: String,
    val paging: PagingAPIEntity,
    val parameters: ParametersAPIEntity,
    val response: List<MatchAPIEntity>,
    val results: Int
)

fun MatchResponseAPIEntity.toDomain() = MatchResponse(
    response = this.response.map { it.toDomain() },
    results = this.results
)