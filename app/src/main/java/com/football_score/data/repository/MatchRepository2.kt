package com.football_score.data.repository

import com.football_score.data.remote.model.MatchResponse

interface MatchRepository2 {
    suspend fun getAllLiveMatch(): MatchResponse
}