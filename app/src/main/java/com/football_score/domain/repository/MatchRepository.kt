package com.football_score.domain.repository

import com.football_score.domain.model.response.LeagueTeamResponse
import com.football_score.domain.model.response.MatchResponse

interface MatchRepository {
    suspend fun getAllLiveMatch(): MatchResponse
    suspend fun getLeagueTeam( ): LeagueTeamResponse
    suspend fun getHotMatches(): MatchResponse
}