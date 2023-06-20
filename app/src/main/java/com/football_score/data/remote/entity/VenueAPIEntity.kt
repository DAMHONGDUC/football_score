package com.football_score.data.remote.entity

import com.football_score.domain.model.Venue

data class VenueAPIEntity(
    val id: Int,
    val name: String?,
    val address: String?,
    val city: String?,
    val capacity: Int,
    val surface: String?,
    val image: String?,
)

fun VenueAPIEntity.toDomain() = Venue(city = this.city, id = this.id, name = this.name)