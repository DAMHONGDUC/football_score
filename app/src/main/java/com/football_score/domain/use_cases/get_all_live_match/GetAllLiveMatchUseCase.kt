package com.football_score.domain.use_cases.get_all_live_match

import com.football_score.data.remote.model.LiveMatchResponse
import com.football_score.data.remote.service.FootballAPIService
import com.football_score.domain.use_cases.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllLiveMatchUseCase(private val repository: MatchRepository) {
    suspend operator fun invoke() = repository.getAllLiveMatch();
}