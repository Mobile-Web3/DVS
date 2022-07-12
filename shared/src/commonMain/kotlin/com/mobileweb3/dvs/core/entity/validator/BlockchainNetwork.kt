package com.mobileweb3.dvs.core.entity.validator

enum class BlockchainNetwork(
    val title: String,
    val imageRef: String,
    val validatorRef: String? = null,
    val proposalsRef: String? = null,
    val isCosmosNetwork: Boolean = false
) {

    //non-cosmos
    SOLANA(
        "Solana",
        "https://s2.coinmarketcap.com/static/img/coins/64x64/5426.png",
        "https://www.validators.app/validators/mainnet"
    ),

    //cosmos
    JUNO(
        "Juno",
        "https://s2.coinmarketcap.com/static/img/coins/64x64/14299.png",
        "https://www.mintscan.io/juno/validators",
        "https://www.mintscan.io/juno/proposals",
        true
    );
}