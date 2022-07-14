package com.mobileweb3.dvs.core.entity.validator

enum class BlockchainNetwork(
    val title: String,
    val chain: String,
    val imageRef: String,
    val validatorRef: String? = null,
    val getProposalsRef: String? = null,
    val exploreProposalRef: String? = null,
    val getTransactionsRef: String? = null,
    val exploreTransactionRef: String? = null,
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
        getProposalsRef = "https://api.mintscan.io/v1/juno/proposals",
        exploreProposalRef = "https://www.mintscan.io/juno/proposals",
        getTransactionsRef = "https://api-juno.cosmostation.io/v1/account/new_txs",
        exploreTransactionRef = "https://www.mintscan.io/juno/txs",
        isCosmosNetwork = true
    ),

    OMNIFLIX(
        title = "Omniflix",
        chain = "omniflix",
        imageRef = "https://static.tildacdn.com/tild3632-6535-4136-b362-356132663835/omniflix.png",
        validatorRef = "https://www.mintscan.io/omniflix/validators",
        getProposalsRef = "https://api.mintscan.io/v1/omniflix/proposals",
        exploreProposalRef = "https://www.mintscan.io/omniflix/proposals",
        getTransactionsRef = "https://api-omniflix.cosmostation.io/v1/account/new_txs",
        exploreTransactionRef = "https://www.mintscan.io/omniflix/txs",
        isCosmosNetwork = true
    ),

    EVMOS(
        title = "Evmos",
        chain = "evmos",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/19899.png",
        validatorRef = "https://www.mintscan.io/evmos/validators",
        getProposalsRef = "https://api.mintscan.io/v1/evmos/proposals",
        exploreProposalRef = "https://www.mintscan.io/evmos/proposals",
        getTransactionsRef = "https://api-evmos.cosmostation.io/v1/account/new_txs",
        exploreTransactionRef = "https://www.mintscan.io/evmos/txs",
        isCosmosNetwork = true
    );
}