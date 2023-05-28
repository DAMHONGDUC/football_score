package com.football_score.data.repository

import com.football_score.data.remote.FootballAPIService
import com.football_score.domain.use_cases.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(private val footballAPIService: FootballAPIService) :
    MatchRepository {
    override suspend fun getAllLiveMatch(): com.football_score.domain.model.LiveMatchResponse =
        footballAPIService.getAllLiveMatch();
}