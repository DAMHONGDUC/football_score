package com.football_score.data.remote.entity

import com.football_score.domain.model.Team

data class TeamAPIEntity(
    val id: Int,
    val logo: String,
    val name: String,
    val winner: Boolean?
)

fun TeamAPIEntity.toDomain() = Team(
    id = this.id,
    logo = this.logo,
    name = this.name,
    winner = this.winner
)