@file:JvmName("LiveMatchResponseKt")

package com.football_score.data.remote.match

import com.football_score.data.remote.entity.PagingAPIEntity
import com.football_score.data.remote.entity.ParametersAPIEntity
import com.football_score.domain.model.MatchResponse

data class BaseMatchResponse(
    val get: String,
    val parameters: ParametersAPIEntity,
    val errors: List<Any>,
    val results: Int,
    val paging: PagingAPIEntity,
    val response: List<com.football_score.data.remote.match.MatchResponse>,
)

fun BaseMatchResponse.toDomain() = MatchResponse(
    response = this.response.map { it.toDomain() },
    results = this.results
)