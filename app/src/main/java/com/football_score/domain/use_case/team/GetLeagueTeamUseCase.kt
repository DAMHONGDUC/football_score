package com.football_score.domain.use_case.team

import com.football_score.domain.repository.MatchRepository

class GetLeagueTeamUseCase(private val repository: MatchRepository) {
    suspend operator fun invoke() = repository.getLeagueTeam();
}