package com.football_score.data.repository

import com.football_score.data.remote.FootballAPIService
import com.football_score.domain.model.LiveMatchResponse
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(private val footballAPIService: FootballAPIService) :
    MatchRepository {
    override suspend fun getAllLiveMatch(): LiveMatchResponse =
        footballAPIService.getAllLiveMatch();
}