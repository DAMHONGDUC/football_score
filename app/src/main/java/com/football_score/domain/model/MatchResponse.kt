package com.football_score.domain.model

data class MatchResponse(
//    val errors: List<Any>,
//    val `get`: String,
//    val paging: Paging,
//    val parameters: Parameters,
    val response: List<Match>,
    val results: Int
)