package com.mobileweb3.dvs.core.entity.transaction

import kotlinx.serialization.Serializable

@Serializable
data class PingPubTransactionsResponse(
    val tx_responses: List<TransactionData>
)