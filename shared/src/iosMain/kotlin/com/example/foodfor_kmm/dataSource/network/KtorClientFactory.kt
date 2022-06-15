package com.example.foodfor_kmm.dataSource.network

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

actual class KtorClientFactory actual constructor() {
    private val nonStrictJson = Json { isLenient = true;ignoreUnknownKeys = true }
    actual fun build(): HttpClient {
        return HttpClient(Ios) {
            install(ContentNegotiation) {
                json(nonStrictJson)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }

    }
}