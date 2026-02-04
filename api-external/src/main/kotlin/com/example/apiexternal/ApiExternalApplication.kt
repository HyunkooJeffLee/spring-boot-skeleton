package com.example.apiexternal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example"])
class ApiExternalApplication

fun main(args: Array<String>) {
    runApplication<ApiExternalApplication>(*args)
}
