package com.football_score.data.remote.entity.league_team_response

import com.football_score.data.remote.entity.*
import com.football_score.domain.model.LeagueTeam

data class TeamResponseAPIEntity(
    val teams: TeamsAPIEntity,
    val venue: VenueAPIEntity
)

fun TeamResponseAPIEntity.toDomain() = LeagueTeam(
    teams = this.teams.toDomain(),
    venue = this.venue.toDomain(),
)