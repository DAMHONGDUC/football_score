package com.football_score.domain.model.response

import com.football_score.domain.model.Match

data class MatchResponse(
    val response: List<Match>,
    val results: Int,
    val errors: List<Any>,
)