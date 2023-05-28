package com.football_score.domain.model

data class Match(
    val events: List<com.football_score.domain.model.Event>,
    val fixture: com.football_score.domain.model.Fixture,
    val goals: com.football_score.domain.model.Goals,
    val league: com.football_score.domain.model.League,
    val score: com.football_score.domain.model.Score,
    val teams: com.football_score.domain.model.Teams
)