package com.football_score.data.remote.entity

import com.football_score.domain.model.Status

data class StatusAPIEntity(
    val elapsed: Int,
    val long: String,
    val short: String
)

fun StatusAPIEntity.toDomain() =
    Status(elapsed = this.elapsed, long = this.long, short = this.short)