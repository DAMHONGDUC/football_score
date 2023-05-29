package com.football_score.data.remote.entity

import com.football_score.domain.model.Team

data class TeamsAPIEntity(
    val away: Team,
    val home: Team
)