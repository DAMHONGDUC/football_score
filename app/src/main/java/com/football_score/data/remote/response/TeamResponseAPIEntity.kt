package com.football_score.data.remote.response

import com.football_score.data.remote.entity.*
import com.football_score.domain.model.LeagueTeam

data class TeamResponseAPIEntity(
    val team: TeamAPIEntity,
    val venue: VenueAPIEntity
)

fun TeamResponseAPIEntity.toDomain() = LeagueTeam(
    team = this.team.toDomain(),
    venue = this.venue.toDomain(),
)