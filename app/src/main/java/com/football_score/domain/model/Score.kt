package com.football_score.domain.model

data class Score(
    val extratime: ScoreItem,
    val fulltime: ScoreItem,
    val halftime: ScoreItem,
    val penalty: ScoreItem
)