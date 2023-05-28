package com.football_score.domain.model

data class League(
    val country: String,
    val flag: String,
    val id: Int,
    val logo: String,
    val name: String,
    val round: String,
    val season: Int
)