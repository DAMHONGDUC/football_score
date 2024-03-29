package com.football_score.domain.model

data class Fixture(
    val date: String,
    val id: Int,
    val periods: Periods,
    val referee: String?,
    val status: Status,
    val timestamp: Long,
    val timezone: String,
    val venue: Venue
)