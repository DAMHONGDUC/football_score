package com.football_score.domain.repository

import com.football_score.domain.response.MatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): MatchResponse

    suspend fun getAllHotMatch(): MatchResponse

//    suspend fun getLeagueMatch( ): MatchResponse
}