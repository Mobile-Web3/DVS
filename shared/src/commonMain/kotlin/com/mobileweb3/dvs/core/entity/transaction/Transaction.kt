package com.mobileweb3.dvs.core.entity.transaction

import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val data: TransactionData
)

@Serializable
data class TransactionData(
    val tx: Tx,
    val txhash: String,
    val raw_log: String? = null
)

@Serializable
data class Tx(
    val body: TxBody
)

@Serializable
data class TxBody(
    val messages: List<TxMessage>? = null
)

@Serializable
data class TxMessage(
    val option: String? = null,
    val proposal_id: String? = null
)