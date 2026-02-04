package com.example.apiinternal.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping("/liveness")
    fun liveness(): Map<String, String> = mapOf("status" to "ok")

    @GetMapping("/readiness")
    fun readiness(): Map<String, String> = mapOf("status" to "ok")
}
