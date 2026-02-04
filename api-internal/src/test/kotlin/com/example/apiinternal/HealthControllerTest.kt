package com.example.apiinternal

import com.example.apiinternal.controllers.HealthController
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(HealthController::class)
class HealthControllerTest(
    @Autowired private val mockMvc: MockMvc,
) {
    @Test
    fun livenessReturnsOk() {
        mockMvc.perform(get("/liveness"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("\"status\":\"ok\"")))
    }

    @Test
    fun readinessReturnsOk() {
        mockMvc.perform(get("/readiness"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("\"status\":\"ok\"")))
    }
}
