package com.football_score.data.remote

import com.football_score.data.remote.match.BaseMatchResponse
import com.football_score.utils.EndPoint
import retrofit2.http.GET

interface FootballAPIService {
    @GET(EndPoint.GET_ALL_LIVE_MATCH)
    suspend fun getAllLiveMatch(): BaseMatchResponse

    @GET(EndPoint.GET_ALL_HOT_MATCH)
    suspend fun getAllHotMatch(): BaseMatchResponse
}