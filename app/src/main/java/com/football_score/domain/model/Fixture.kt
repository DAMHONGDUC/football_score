package com.football_score.domain.model

data class Fixture(
    val date: String,
    val id: Int,
    val periods: com.football_score.domain.model.Periods,
    val referee: String,
    val status: com.football_score.domain.model.Status,
    val timestamp: Int,
    val timezone: String,
    val venue: com.football_score.domain.model.Venue
)