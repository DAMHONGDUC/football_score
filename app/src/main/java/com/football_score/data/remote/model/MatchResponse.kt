package com.football_score.data.remote.model

import com.football_score.data.a_test.Paging
import com.football_score.data.a_test.Parameters
import com.football_score.data.a_test.Response

data class MatchResponse(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)