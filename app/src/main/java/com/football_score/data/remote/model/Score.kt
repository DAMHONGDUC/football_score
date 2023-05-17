package com.football_score.data.remote.model

data class Score(
    val extratime: Extratime,
    val fulltime: Fulltime,
    val halftime: Halftime,
    val penalty: Penalty
)