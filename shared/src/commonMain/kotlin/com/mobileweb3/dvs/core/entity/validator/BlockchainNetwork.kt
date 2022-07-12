package com.mobileweb3.dvs.core.entity.validator

enum class BlockchainNetwork(
    val title: String,
    val chain: String,
    val imageRef: String,
    val validatorRef: String? = null,
    val proposalsRef: String? = null,
    val transactionsRef: String? = null,
    val isCosmosNetwork: Boolean = false
) {

    //non-cosmos
    SOLANA(
        title = "Solana",
        chain = "Solana",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/5426.png",
        validatorRef = "https://www.validators.app/validators/mainnet"
    ),

    //cosmos
    JUNO(
        title = "Juno",
        chain = "juno",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/14299.png",
        validatorRef = "https://www.mintscan.io/juno/validators",
        proposalsRef = "https://api.mintscan.io/v1/juno/proposals",
        transactionsRef = "https://api-juno.cosmostation.io/v1/account/new_txs",
        isCosmosNetwork = true
    );
}