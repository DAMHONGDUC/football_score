package com.football_score.data.remote.service

import com.football_score.utils.EndPoint
import com.football_score.data.remote.model.LiveMatchResponse
import retrofit2.http.GET

interface FootballAPIService {
    @GET(EndPoint.GET_ALL_LIVE_MATCH)
    suspend fun getAllLiveMatch(): LiveMatchResponse
}