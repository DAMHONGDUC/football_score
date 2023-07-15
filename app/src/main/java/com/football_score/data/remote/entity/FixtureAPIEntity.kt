package com.football_score.data.remote.entity

import com.football_score.domain.model.Fixture

data class FixtureAPIEntity(
    val date: String,
    val id: Int,
    val periods: PeriodsAPIEntity,
    val referee: String?,
    val status: StatusAPIEntity,
    val timestamp: Long,
    val timezone: String,
    val venue: VenueAPIEntity
)

fun FixtureAPIEntity.toDomain() = Fixture(
    date = this.date,
    id = this.id,
    periods = this.periods.toDomain(),
    referee = this.referee,
    status = this.status.toDomain(),
    timestamp = this.timestamp,
    timezone = this.timezone,
    venue = this.venue.toDomain(),
)