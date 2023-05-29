package com.football_score.data.remote.entity

import com.football_score.domain.model.Venue

data class VenueAPIEntity(
    val city: String?,
    val id: Int?,
    val name: String?
)

fun VenueAPIEntity.toDomain() = Venue(city = this.city, id = this.id, name = this.name)