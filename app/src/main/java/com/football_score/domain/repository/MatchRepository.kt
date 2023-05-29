package com.football_score.domain.repository

import com.football_score.domain.model.LiveMatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): LiveMatchResponse
}