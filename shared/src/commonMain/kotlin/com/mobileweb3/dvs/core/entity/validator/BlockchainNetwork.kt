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
    ),

    STARGAZE(
        title = "Stargaze",
        chain = "stargaze",
        landingRef = "https://www.stargaze.zone/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/16842.png",
        validatorsListRef = "stargaze".toCosmosValidators(),
        getProposalsRef = "stargaze".toGetCosmosProposals(),
        exploreProposalRef = "stargaze".toCosmosProposals(),
        getTransactionsRef = "stargaze".toGetCosmosTransactions(),
        exploreTransactionRef = "stargaze".toExploreCosmosTransaction(),
        validatorInfoRef = "stargaze".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    CERTIK(
        title = "Certik",
        chain = "certik",
        landingRef = "https://www.certik.com/",
        imageRef = "https://www.mintscan.io/_next/static/image/assets/Dashboard/chain_certik.8ae38e6334ad25a00b7808b5747e7374.svg",
        validatorsListRef = "certik".toCosmosValidators(),
        getProposalsRef = "certik".toGetCosmosProposals(),
        exploreProposalRef = "certik".toCosmosProposals(),
        getTransactionsRef = "certik".toGetCosmosTransactions(),
        exploreTransactionRef = "certik".toExploreCosmosTransaction(),
        validatorInfoRef = "certik".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    BOSTROM(
        title = "Bostrom",
        chain = "bostrom",
        landingRef = "https://cyb.ai/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/19111.png",
        validatorsListRef = "https://cyb.ai/network/bostrom/hero",
        getProposalsRef = "https://lcd.bostrom.cybernode.ai/gov/proposals",
        exploreProposalRef = "https://cyb.ai/senate",
        getTransactionsRef = "", //seems like it getting from socket
        exploreTransactionRef = "https://cyb.ai/network/bostrom/tx",
        validatorInfoRef = "", //seems like it getting from socket
        isCosmosNetwork = true
    ),

    MICROTICK(
        title = "Microtick",
        chain = "microtick",
        landingRef = "https://explorer.microtick.zone/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/17451.png",
        validatorsListRef = "https://explorer.microtick.zone/validators",
        getProposalsRef = "",
        exploreProposalRef = "https://explorer.microtick.zone/proposals",
        getTransactionsRef = "",
        exploreTransactionRef = "https://explorer.microtick.zone/transactions",
        validatorInfoRef = "",
        isCosmosNetwork = true
    ),

    RIZON(
        title = "Rizon",
        chain = "rizon",
        landingRef = "https://rizon.world/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/15388.png",
        validatorsListRef = "rizon".toCosmosValidators(),
        getProposalsRef = "rizon".toGetCosmosProposals(),
        exploreProposalRef = "rizon".toCosmosProposals(),
        getTransactionsRef = "rizon".toGetCosmosTransactions(),
        exploreTransactionRef = "rizon".toExploreCosmosTransaction(),
        validatorInfoRef = "rizon".toGetCosmosValidator(),
        isCosmosNetwork = true
    );
}