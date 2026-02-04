package com.example.apiinternal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example"])
class ApiInternalApplication

fun main(args: Array<String>) {
    runApplication<ApiInternalApplication>(*args)
}
