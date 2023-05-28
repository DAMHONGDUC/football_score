package com.football_score.domain.use_cases.get_all_live_match

import com.football_score.domain.use_cases.MatchRepository

class GetAllLiveMatchUseCase(private val repository: MatchRepository) {
    suspend operator fun invoke() = repository.getAllLiveMatch();
}