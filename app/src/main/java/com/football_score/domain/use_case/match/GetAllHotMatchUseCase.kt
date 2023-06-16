package com.football_score.domain.use_case.match

import com.football_score.domain.repository.MatchRepository

class GetAllHotMatchUseCase(private val repository: MatchRepository) {
    suspend operator fun invoke() = repository.getAllHotMatch();
}