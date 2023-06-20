package com.football_score.data.remote.service

import com.football_score.data.remote.entity.match.BaseMatchResponseAPIEntity
import com.football_score.utils.EndPoint
import retrofit2.http.GET

interface FootballAPIService {
    @GET(EndPoint.GET_ALL_LIVE_MATCH)
    suspend fun getAllLiveMatch(): BaseMatchResponseAPIEntity

    @GET(EndPoint.GET_ALL_HOT_MATCH)
    suspend fun getAllHotMatch(): BaseMatchResponseAPIEntity
}