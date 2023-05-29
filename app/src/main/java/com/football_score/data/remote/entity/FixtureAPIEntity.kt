package com.football_score.data.remote.entity

data class FixtureAPIEntity(
    val date: String,
    val id: Int,
    val periods: PeriodsAPIEntity,
    val referee: String?,
    val status: StatusAPIEntity,
    val timestamp: Int,
    val timezone: String,
    val venue: VenueAPIEntity
)