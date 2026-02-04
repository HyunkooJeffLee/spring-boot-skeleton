package com.example.apiinternal.service

import org.springframework.stereotype.Service

@Service
class BatchService {
    fun process(limit: Int): BatchResult {
        return BatchResult(
            processed = limit,
            message = "api-internal processed $limit items",
        )
    }
}
