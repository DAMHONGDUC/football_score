package com.football_score.data.remote.entity

import com.football_score.domain.model.ErrorResponse

class ErrorResponseAPIEntity(val requests: String?)

fun ErrorResponseAPIEntity.toDomain() = ErrorResponse(
    requests = this.requests
)