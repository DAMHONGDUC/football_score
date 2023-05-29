package com.football_score.data.remote.entity

import com.football_score.domain.model.Score

data class ScoreAPIEntity(
    val extratime: ScoreItemAPIEntity,
    val fulltime: ScoreItemAPIEntity,
    val halftime: ScoreItemAPIEntity,
    val penalty: ScoreItemAPIEntity
)

fun ScoreAPIEntity.toDomain() = Score(
    extratime = this.extratime.toDomain(),
    fulltime = this.fulltime.toDomain(),
    halftime = this.halftime.toDomain(),
    penalty = this.penalty.toDomain(),
)