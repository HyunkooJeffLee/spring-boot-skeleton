package com.example.apibackoffice.service

data class BatchResult(
    val processed: Int,
    val message: String,
) {
    fun toMap(): Map<String, Any> = mapOf(
        "processed" to processed,
        "message" to message,
    )
}
