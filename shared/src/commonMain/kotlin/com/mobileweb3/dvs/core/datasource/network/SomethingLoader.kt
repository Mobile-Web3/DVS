package com.mobileweb3.dvs.core.datasource.network

import com.mobileweb3.dvs.core.entity.SomethingResponse
import com.mobileweb3.dvs.core.entity.proposal.Proposal
import com.mobileweb3.dvs.core.entity.transaction.Transaction
import com.mobileweb3.dvs.core.entity.validator.ValidatorInfo
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SomethingLoader(
    private val httpClient: HttpClient
) {

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    suspend fun getSomething(url: String): SomethingResponse {
        return json.decodeFromString(httpClient.get(url).bodyAsText())
    }

    suspend fun getProposalsFromMintScan(url: String): List<Proposal> {
        return json.decodeFromString(httpClient.get(url).bodyAsText())
    }

    //cosmos1vvwtk805lxehwle9l4yudmq6mn0g32pxqjlrmt
    suspend fun getValidatorTransactions(url: String): List<Transaction> {
        return json.decodeFromString(
            // also there is another path to get tx-ns "https://api.cosmostation.io/v1/account/txs/$validationAddress?limit=100&from=0"
            httpClient.get("$url?limit=100&from=0").bodyAsText()
        )
    }

    suspend fun getValidatorInfo(url: String): ValidatorInfo {
        return json.decodeFromString(httpClient.get(url).bodyAsText())
    }
}