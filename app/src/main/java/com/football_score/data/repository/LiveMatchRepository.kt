package com.football_score.data.repository

import com.football_score.data.remote.model.LiveMatchResponse
import com.football_score.data.remote.service.FootballAPIService
import javax.inject.Inject

class LiveMatchRepository @Inject constructor(private val footballAPIService: FootballAPIService) {

    suspend fun getAllLiveMatch(): LiveMatchResponse = footballAPIService.getAllLiveMatch();
}