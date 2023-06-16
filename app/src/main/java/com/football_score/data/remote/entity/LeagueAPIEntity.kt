package com.football_score.data.remote.entity

import com.football_score.domain.model.League

data class LeagueAPIEntity(
    val country: String,
    val flag: String?,
    val id: Int,
    val logo: String,
    val name: String,
    val round: String,
    val season: Int
)

fun LeagueAPIEntity.toDomain() = League(
    country = this.country,
    flag = this.flag,
    id = this.id,
    logo = this.logo,
    name = this.name,
    round = this.round,
    season = this.season,
)