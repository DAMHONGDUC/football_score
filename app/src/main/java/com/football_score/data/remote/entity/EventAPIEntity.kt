package com.football_score.data.remote.entity

data class
EventAPIEntity(
    val assist: AssistAPIEntity,
    val comments: String?,
    val detail: String,
    val player: PlayerAPIEntity,
    val team: TeamAPIEntity,
    val time: TimeAPIEntity,
    val type: String
)
