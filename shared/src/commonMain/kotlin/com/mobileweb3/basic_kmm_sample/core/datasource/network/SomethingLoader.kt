package com.mobileweb3.basic_kmm_sample.core.datasource.network

import com.mobileweb3.basic_kmm_sample.core.entity.SomethingResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SomethingLoader(
    private val httpClient: HttpClient
) {

    suspend fun getSomething(url: String): SomethingResponse {
        return Json.decodeFromString(httpClient.get(url).bodyAsText())
    }
}