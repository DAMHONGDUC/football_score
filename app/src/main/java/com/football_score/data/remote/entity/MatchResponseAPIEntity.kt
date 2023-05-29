package com.football_score.data.remote.entity

data class MatchResponseAPIEntity(
    val errors: List<Any>,
    val `get`: String,
    val paging: PagingAPIEntity,
    val parameters: ParametersAPIEntity,
    val response: List<MatchAPIEntity>,
    val results: Int
)