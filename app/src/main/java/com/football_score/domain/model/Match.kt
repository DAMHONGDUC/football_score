package com.football_score.domain.model

import com.football_score.data.remote.entity.FixtureAPIEntity

data class Match(
    val fixture: Fixture,
    val goals: Goals,
    val league: League,
    val score: Score,
    val teams: Teams
)