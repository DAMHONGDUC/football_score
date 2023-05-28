package com.football_score.domain.use_cases

import com.football_score.domain.model.LiveMatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): LiveMatchResponse
}