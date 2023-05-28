package com.football_score.domain.model

data class Score(
    val extratime: com.football_score.domain.model.Extratime,
    val fulltime: com.football_score.domain.model.Fulltime,
    val halftime: com.football_score.domain.model.Halftime,
    val penalty: com.football_score.domain.model.Penalty
)