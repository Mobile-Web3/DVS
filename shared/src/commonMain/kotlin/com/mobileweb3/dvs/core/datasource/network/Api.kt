package com.mobileweb3.dvs.core.datasource.network

import com.mobileweb3.dvs.core.entity.proposal.BostromProposals
import com.mobileweb3.dvs.core.entity.proposal.ChronicProposals
import com.mobileweb3.dvs.core.entity.proposal.Proposal
import com.mobileweb3.dvs.core.entity.proposal.toDefaultProposals
import com.mobileweb3.dvs.core.entity.transaction.Transaction
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorInfo
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class Api(
    val httpClient: HttpClient
) {

    val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    suspend fun getProposals(blockchainNetwork: BlockchainNetwork): List<Proposal> {
        val url = blockchainNetwork.getProposalsRef ?: return emptyList()

        if (blockchainNetwork == BlockchainNetwork.BOSTROM) {
            val bostromProposals: BostromProposals = json.decodeFromString(httpClient.get(url).bodyAsText())
            return bostromProposals.toDefaultProposals()
        }

        if (blockchainNetwork == BlockchainNetwork.CHRONIC) {
            val chronicProposals: ChronicProposals = json.decodeFromString(httpClient.get(url).bodyAsText())
            return chronicProposals.toDefaultProposals()
        }

        return json.decodeFromString(httpClient.get(url).bodyAsText())
    }

    suspend fun getProposalsNew(url: String): List<Proposal> {
        return json.decodeFromString(httpClient.get(url).bodyAsText())
    }

    suspend fun getValidatorTransactions(url: String): List<Transaction> {
        return json.decodeFromString(
            // also there is another path to get tx-ns "https://api.cosmostation.io/v1/account/txs/$validationAddress?limit=100&from=0"
            httpClient.get("$url?limit=100&from=0").bodyAsText()
        )
    }

    suspend inline fun <reified T> getValidatorTransactionsNew(url: String): T {
        return json.decodeFromString(
            // also there is another path to get tx-ns "https://api.cosmostation.io/v1/account/txs/$validationAddress?limit=100&from=0"
            httpClient.get("$url").bodyAsText()
        )
    }

    suspend fun getValidatorInfo(url: String): ValidatorInfo {
        return json.decodeFromString(httpClient.get(url).bodyAsText())
    }
}