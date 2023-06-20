package com.football_score.domain.repository

import com.football_score.domain.model.response.MatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): MatchResponse

    suspend fun getAllHotMatch(): MatchResponse

    suspend fun getLeagueTeam( ): MatchResponse
}