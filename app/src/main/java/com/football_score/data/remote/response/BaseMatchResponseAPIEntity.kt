package com.football_score.data.remote.response

import com.football_score.data.remote.entity.PagingAPIEntity
import com.football_score.data.remote.entity.ParametersAPIEntity
import com.football_score.domain.model.response.MatchResponse

data class BaseMatchResponseAPIEntity(
    val get: String,
    val parameters: ParametersAPIEntity,
    val errors: Any, // errors can be object or array
    val results: Int,
    val paging: PagingAPIEntity,
    val response: List<MatchResponseAPIEntity>,
)

fun BaseMatchResponseAPIEntity.toDomain() = MatchResponse(
    response = this.response.map { it.toDomain() },
    results = this.results,
    errors = this.errors
)