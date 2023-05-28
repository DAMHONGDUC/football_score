package com.football_score.domain.use_cases

import com.football_score.domain.model.LiveMatchResponse
import kotlinx.coroutines.flow.Flow

interface MatchRepository {
    suspend fun getAllLiveMatch(): com.football_score.domain.model.LiveMatchResponse
}