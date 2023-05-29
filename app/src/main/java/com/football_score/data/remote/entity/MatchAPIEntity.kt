package com.football_score.data.remote.entity

import com.football_score.domain.model.*

data class MatchAPIEntity(
    val events: List<EventAPIEntity>,
    val fixture: FixtureAPIEntity,
    val goals: GoalsAPIEntity,
    val league: LeagueAPIEntity,
    val score: ScoreAPIEntity,
    val teams: TeamsAPIEntity
)

fun MatchAPIEntity.toDomain() = Match(
 goals = this.goals.toDomain(),
league = this.league.toDomain(),
score = this.score.toDomain(),
 teams= this.teams.toDomain(),
)