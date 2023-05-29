package com.football_score.data.remote.entity

import com.football_score.domain.model.Team
import com.football_score.domain.model.Teams

data class TeamsAPIEntity(
    val away: TeamAPIEntity,
    val home: TeamAPIEntity
)

fun TeamsAPIEntity.toDomain() = Teams(
    home = this.home.toDomain(),
    away = this.away.toDomain(),
)