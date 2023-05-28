package com.football_score.domain.model

data class Event(
    val assist: com.football_score.domain.model.Assist,
    val comments: String,
    val detail: String,
    val player: com.football_score.domain.model.Player,
    val team: com.football_score.domain.model.Team,
    val time: com.football_score.domain.model.Time,
    val type: String
)