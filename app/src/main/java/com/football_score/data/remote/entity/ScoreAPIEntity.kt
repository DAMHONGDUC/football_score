package com.football_score.data.remote.entity

data class ScoreAPIEntity(
    val extratime: ExtratimeAPIEntity,
    val fulltime: FulltimeAPIEntity,
    val halftime: HalftimeAPIEntity,
    val penalty: PenaltyAPIEntity
)