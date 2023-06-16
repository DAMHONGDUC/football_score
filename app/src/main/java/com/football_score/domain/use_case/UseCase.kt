package com.football_score.domain.use_case

import com.football_score.domain.use_case.match.GetAllHotMatchUseCase
import com.football_score.domain.use_case.match.GetAllLiveMatchUseCase

data class UseCase(
    val getAllLiveMatch: GetAllLiveMatchUseCase,

    val getAllHotMatch: GetAllHotMatchUseCase
)

