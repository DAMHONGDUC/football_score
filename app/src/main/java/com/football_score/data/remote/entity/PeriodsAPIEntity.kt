package com.football_score.data.remote.entity

import com.football_score.domain.model.Periods

data class PeriodsAPIEntity(
    val first: Int,
    val second: Int?
)

fun PeriodsAPIEntity.toDomain() = Periods(
    first = this.first,
    second = this.second,
)