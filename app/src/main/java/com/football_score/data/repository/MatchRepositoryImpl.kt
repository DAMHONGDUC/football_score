package com.football_score.data.repository

import com.football_score.data.remote.response.toDomain
import com.football_score.data.remote.service.FootballAPIService
import com.football_score.domain.model.response.LeagueTeamResponse
import com.football_score.domain.model.response.MatchResponse
import com.football_score.domain.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(private val footballAPIService: FootballAPIService) :
    MatchRepository {
    override suspend fun getAllLiveMatch(): MatchResponse =
        footballAPIService.getFixtures(live = "all").toDomain();

    override suspend fun getHotMatches(teamId: Int): MatchResponse =
        footballAPIService.getHotMatches(
            league = "39",
            season = "2022",
            teamId = teamId.toString(),
            from = "2023-01-19",
            to = "2023-09-19"
        ).toDomain();

    override suspend fun getLeagueTeam(): LeagueTeamResponse =
        footballAPIService.getLeagues(league = "39", season = "2022", country = "England")
            .toDomain();
}