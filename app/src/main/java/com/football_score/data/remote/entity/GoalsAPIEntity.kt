package com.football_score.data.remote.entity

import com.football_score.domain.model.Goals

data class GoalsAPIEntity(
    val away: Int,
    val home: Int
)

fun GoalsAPIEntity.toDomain() = Goals(
    away = this.away,
    home = this.home
)