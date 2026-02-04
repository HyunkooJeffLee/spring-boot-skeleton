package com.example.apibackoffice.service

import org.springframework.stereotype.Service

@Service
class BatchService {
    fun process(limit: Int): BatchResult {
        return BatchResult(
            processed = limit,
            message = "api-backoffice processed $limit items",
        )
    }
}
