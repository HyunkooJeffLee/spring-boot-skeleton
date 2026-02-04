package com.example.apiexternal.service

import org.springframework.stereotype.Service

@Service
class BatchService {
    fun process(limit: Int): BatchResult {
        return BatchResult(
            processed = limit,
            message = "api-external processed $limit items",
        )
    }
}
