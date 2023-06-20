package com.football_score.data.remote.service

import com.football_score.data.remote.response.BaseLeagueTeamResponseAPIEntity
import com.football_score.data.remote.response.BaseMatchResponseAPIEntity
import com.football_score.utils.EndPoint
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface FootballAPIService {
    @GET(EndPoint.FIXTURES)
    suspend fun getFixtures(@Query("live") live: String?): BaseMatchResponseAPIEntity

    @GET(EndPoint.TEAMS)
    suspend fun getLeagues(
        @Query("league") league: String?,
        @Query("season") season: String?,
        @Query("country") country: String?,
    ): BaseLeagueTeamResponseAPIEntity
}