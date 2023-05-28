package com.football_score.domain.model

data class Team(
    val id: Int,
    val logo: String,
    val name: String,
    val winner: Boolean?
)