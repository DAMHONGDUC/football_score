package com.football_score.domain.use_cases

import com.football_score.data.remote.model.LiveMatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): LiveMatchResponse
}