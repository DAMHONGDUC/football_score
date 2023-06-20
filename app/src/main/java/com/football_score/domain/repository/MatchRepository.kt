package com.football_score.domain.repository

import com.football_score.domain.model.match.MatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): MatchResponse

    suspend fun getAllHotMatch(): MatchResponse
}