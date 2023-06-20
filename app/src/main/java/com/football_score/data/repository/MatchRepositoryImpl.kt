package com.football_score.data.repository

import com.football_score.data.remote.service.FootballAPIService
import com.football_score.data.remote.entity.match.toDomain
import com.football_score.domain.model.match.MatchResponse
import com.football_score.domain.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(private val footballAPIService: FootballAPIService) :
    MatchRepository {
    override suspend fun getAllLiveMatch(): MatchResponse =
        footballAPIService.getAllLiveMatch().toDomain();

    override suspend fun getAllHotMatch(): MatchResponse =
        footballAPIService.getAllHotMatch().toDomain();
}