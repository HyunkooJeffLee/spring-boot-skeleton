package com.example.apibackoffice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example"])
class ApiBackofficeApplication

fun main(args: Array<String>) {
    runApplication<ApiBackofficeApplication>(*args)
}
