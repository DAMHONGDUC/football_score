package com.football_score.data.remote.model

data class LiveMatchResponse(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Match>,
    val results: Int
)