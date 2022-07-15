package com.mobileweb3.dvs.core.entity.validator

import com.mobileweb3.dvs.utils.toCosmosProposals
import com.mobileweb3.dvs.utils.toExploreCosmosTransaction
import com.mobileweb3.dvs.utils.toGetCosmosProposals
import com.mobileweb3.dvs.utils.toCosmosValidators
import com.mobileweb3.dvs.utils.toGetCosmosTransactions
import com.mobileweb3.dvs.utils.toGetCosmosValidator

enum class BlockchainNetwork(
    val title: String,
    val chain: String,
    val imageRef: String,
    val landingRef: String,
    val validatorsListRef: String? = null,
    val getProposalsRef: String? = null,
    val exploreProposalRef: String? = null,
    val getTransactionsRef: String? = null,
    val exploreTransactionRef: String? = null,
    val validatorInfoRef: String? = null,
    val isCosmosNetwork: Boolean = false
) {

    //non-cosmos
    SOLANA(
        title = "Solana",
        chain = "Solana",
        landingRef = "https://solana.com/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/5426.png",
        validatorsListRef = "https://www.validators.app/validators/mainnet"
    ),

    //cosmos
    JUNO(
        title = "Juno",
        chain = "juno",
        landingRef = "https://www.junonetwork.io/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/14299.png",
        validatorsListRef = "juno".toCosmosValidators(),
        getProposalsRef = "juno".toGetCosmosProposals(),
        exploreProposalRef = "juno".toCosmosProposals(),
        getTransactionsRef = "juno".toGetCosmosTransactions(),
        exploreTransactionRef = "juno".toExploreCosmosTransaction(),
        validatorInfoRef = "juno".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    OMNIFLIX(
        title = "Omniflix",
        chain = "omniflix",
        landingRef = "https://omniflix.network/",
        imageRef = "https://static.tildacdn.com/tild3632-6535-4136-b362-356132663835/omniflix.png",
        validatorsListRef = "omniflix".toCosmosValidators(),
        getProposalsRef = "omniflix".toGetCosmosProposals(),
        exploreProposalRef = "omniflix".toCosmosProposals(),
        getTransactionsRef = "omniflix".toGetCosmosTransactions(),
        exploreTransactionRef = "omniflix".toExploreCosmosTransaction(),
        validatorInfoRef = "omniflix".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    EVMOS(
        title = "Evmos",
        chain = "evmos",
        landingRef = "https://evmos.org/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/19899.png",
        validatorsListRef = "evmos".toCosmosValidators(),
        getProposalsRef = "evmos".toGetCosmosProposals(),
        exploreProposalRef = "evmos".toCosmosProposals(),
        getTransactionsRef = "evmos".toGetCosmosTransactions(),
        exploreTransactionRef = "evmos".toExploreCosmosTransaction(),
        validatorInfoRef = "evmos".toGetCosmosValidator(),
        isCosmosNetwork = true
    );
}