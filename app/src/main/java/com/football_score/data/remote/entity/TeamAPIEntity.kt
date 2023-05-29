package com.football_score.data.remote.entity

data class TeamAPIEntity(
    val id: Int,
    val logo: String,
    val name: String,
    val winner: Boolean?
)