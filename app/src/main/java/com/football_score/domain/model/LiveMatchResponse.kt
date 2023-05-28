package com.football_score.domain.model

data class LiveMatchResponse(
    val errors: List<Any>,
    val `get`: String,
    val paging: com.football_score.domain.model.Paging,
    val parameters: com.football_score.domain.model.Parameters,
    val response: List<com.football_score.domain.model.Match>,
    val results: Int
)