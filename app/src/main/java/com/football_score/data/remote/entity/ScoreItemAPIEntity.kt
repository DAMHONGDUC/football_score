package com.football_score.data.remote.entity

import com.football_score.domain.model.ScoreItem

data class ScoreItemAPIEntity(
    val away: Any?,
    val home: Any?
)

fun ScoreItemAPIEntity.toDomain() = ScoreItem(
    away = this.away,
    home = this.home
)