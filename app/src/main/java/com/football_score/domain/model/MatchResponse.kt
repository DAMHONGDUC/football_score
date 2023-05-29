package com.football_score.domain.model

data class MatchResponse(
    val response: List<Match>,
    val results: Int
)