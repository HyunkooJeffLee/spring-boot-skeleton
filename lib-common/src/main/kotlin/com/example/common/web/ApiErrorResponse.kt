package com.example.common.web

import java.time.Instant

data class ApiErrorResponse(
    val message: String,
    val timestamp: Instant = Instant.now(),
)
