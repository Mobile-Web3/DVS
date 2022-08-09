package com.mobileweb3.dvs.core.entity.validator

import com.mobileweb3.dvs.utils.toExploreCosmosProposals
import com.mobileweb3.dvs.utils.toExploreCosmosTransaction
import com.mobileweb3.dvs.utils.toGetCosmosProposals
import com.mobileweb3.dvs.utils.toExproleCosmosValidators
import com.mobileweb3.dvs.utils.toGetCosmosTransactions
import com.mobileweb3.dvs.utils.toGetCosmosValidator

enum class BlockchainNetwork(
    val title: String,
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
        landingRef = "https://solana.com/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/5426.png",
        validatorsListRef = "https://www.validators.app/validators/mainnet"
    ),

    VELAS(
        title = "Velas",
        landingRef = "https://velas.com/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/4747.png",
        validatorsListRef = "https://velasvalidators.com"
    ),

    AVALANCHE(
        title = "Avalanche",
        landingRef = "https://www.avax.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/5805.png",
        validatorsListRef = "https://avascan.info/staking/validator"
    ),

    MINA(
        title = "Mina",
        landingRef = "https://minaprotocol.com/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/8646.png",
        validatorsListRef = "https://minaexplorer.com/wallet"
    ),

    MOONBEAM(
        title = "Moonbeam",
        landingRef = "https://moonbeam.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/6836.png",
        validatorsListRef = "https://moonbeam.subscan.io/waiting"
    ),

    EVERSCALE(
        title = "Everscale",
        landingRef = "https://everscale.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/7505.png",
        validatorsListRef = "https://ever.live/depools"
    ),

    THE_GRAPH(
        title = "The Graph",
        landingRef = "https://thegraph.com/en/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/6719.png",
        validatorsListRef = "https://thegraph.com/explorer"
    ),

    CASPER(
        title = "Casper",
        landingRef = "https://casper.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/5899.png",
        validatorsListRef = "https://cspr.live/account"
    ),

    IDENA(
        title = "Idena",
        landingRef = "https://idena.io/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/5836.png",
        validatorsListRef = "https://scan.idena.io/address"
    ),

    XX_NETWORK(
        title = "XX network",
        landingRef = "https://xx.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/18995.png",
        validatorsListRef = "https://dashboard.xx.network/nodes"
    ),

    //cosmos
    JUNO(
        title = "Juno",
        landingRef = "https://www.junonetwork.io/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/14299.png",
        validatorsListRef = "juno".toExproleCosmosValidators(),
        getProposalsRef = "juno".toGetCosmosProposals(),
        exploreProposalRef = "juno".toExploreCosmosProposals(),
        getTransactionsRef = "juno".toGetCosmosTransactions(),
        exploreTransactionRef = "juno".toExploreCosmosTransaction(),
        validatorInfoRef = "juno".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    OMNIFLIX(
        title = "Omniflix",
        landingRef = "https://omniflix.network/",
        imageRef = "https://static.tildacdn.com/tild3632-6535-4136-b362-356132663835/omniflix.png",
        validatorsListRef = "omniflix".toExproleCosmosValidators(),
        getProposalsRef = "omniflix".toGetCosmosProposals(),
        exploreProposalRef = "omniflix".toExploreCosmosProposals(),
        getTransactionsRef = "omniflix".toGetCosmosTransactions(),
        exploreTransactionRef = "omniflix".toExploreCosmosTransaction(),
        validatorInfoRef = "omniflix".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    EVMOS(
        title = "Evmos",
        landingRef = "https://evmos.org/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/19899.png",
        validatorsListRef = "evmos".toExproleCosmosValidators(),
        getProposalsRef = "evmos".toGetCosmosProposals(),
        exploreProposalRef = "evmos".toExploreCosmosProposals(),
        getTransactionsRef = "evmos".toGetCosmosTransactions(),
        exploreTransactionRef = "evmos".toExploreCosmosTransaction(),
        validatorInfoRef = "evmos".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    STARGAZE(
        title = "Stargaze",
        landingRef = "https://www.stargaze.zone/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/16842.png",
        validatorsListRef = "stargaze".toExproleCosmosValidators(),
        getProposalsRef = "stargaze".toGetCosmosProposals(),
        exploreProposalRef = "stargaze".toExploreCosmosProposals(),
        getTransactionsRef = "stargaze".toGetCosmosTransactions(),
        exploreTransactionRef = "stargaze".toExploreCosmosTransaction(),
        validatorInfoRef = "stargaze".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    CERTIK(
        title = "Certik",
        landingRef = "https://www.certik.com/",
        imageRef = "https://www.mintscan.io/_next/static/image/assets/Dashboard/chain_certik.8ae38e6334ad25a00b7808b5747e7374.svg",
        validatorsListRef = "certik".toExproleCosmosValidators(),
        getProposalsRef = "certik".toGetCosmosProposals(),
        exploreProposalRef = "certik".toExploreCosmosProposals(),
        getTransactionsRef = "certik".toGetCosmosTransactions(),
        exploreTransactionRef = "certik".toExploreCosmosTransaction(),
        validatorInfoRef = "certik".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    BOSTROM(
        title = "Bostrom",
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

    GRAVITY_BRIDGE(
        title = "Gravity-Bridge",
        landingRef = "https://gravitybridge.persona.co/",
        imageRef = "https://assets.coingecko.com/coins/images/24818/small/Graviton_-_Blue_200x200i.png?1649038479",
        validatorsListRef = "gravity-bridge".toExproleCosmosValidators(),
        getProposalsRef = "gravity-bridge".toGetCosmosProposals(),
        exploreProposalRef = "gravity-bridge".toExploreCosmosProposals(),
        getTransactionsRef = "gravity-bridge".toGetCosmosTransactions(),
        exploreTransactionRef = "gravity-bridge".toExploreCosmosTransaction(),
        validatorInfoRef = "gravity-bridge".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    RIZON(
        title = "Rizon",
        landingRef = "https://rizon.world/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/15388.png",
        validatorsListRef = "rizon".toExproleCosmosValidators(),
        getProposalsRef = "rizon".toGetCosmosProposals(),
        exploreProposalRef = "rizon".toExploreCosmosProposals(),
        getTransactionsRef = "rizon".toGetCosmosTransactions(),
        exploreTransactionRef = "rizon".toExploreCosmosTransaction(),
        validatorInfoRef = "rizon".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    LIKECOIN(
        title = "Likecoin",
        landingRef = "https://likecoin.bigdipper.live/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/2909.png",
        validatorsListRef = "https://likecoin.bigdipper.live/validators",
        getProposalsRef = "",
        exploreProposalRef = "https://likecoin.bigdipper.live/proposals",
        getTransactionsRef = "",
        exploreTransactionRef = "https://likecoin.bigdipper.live/transactions",
        validatorInfoRef = "",
        isCosmosNetwork = true
    ),

    BITCANNA(
        title = "Bitcanna",
        landingRef = "https://www.bitcanna.io/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/4263.png",
        validatorsListRef = "bitcanna".toExproleCosmosValidators(),
        getProposalsRef = "bitcanna".toGetCosmosProposals(),
        exploreProposalRef = "bitcanna".toExploreCosmosProposals(),
        getTransactionsRef = "bitcanna".toGetCosmosTransactions(),
        exploreTransactionRef = "bitcanna".toExploreCosmosTransaction(),
        validatorInfoRef = "bitcanna".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    BITSONG(
        title = "Bitsong",
        landingRef = "https://bitsong.io/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/8905.png",
        validatorsListRef = "bitsong".toExproleCosmosValidators(),
        getProposalsRef = "bitsong".toGetCosmosProposals(),
        exploreProposalRef = "bitsong".toExploreCosmosProposals(),
        getTransactionsRef = "bitsong".toGetCosmosTransactions(),
        exploreTransactionRef = "bitsong".toExploreCosmosTransaction(),
        validatorInfoRef = "bitsong".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    CHRONIC(
        title = "Chronic-token",
        landingRef = "https://www.chronictoken.io/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/11217.png",
        validatorsListRef = "https://www.skynetexplorers.com/chronic-token/staking",
        getProposalsRef = "https://chtd-api.skynetvalidators.com/cosmos/gov/v1beta1/proposals?pagination.limit=500",
        exploreProposalRef = "https://www.skynetexplorers.com/chronic-token/gov",
        getTransactionsRef = "https://chtd-api.skynetvalidators.com/txs?message.sender=",
        exploreTransactionRef = "https://www.skynetexplorers.com/chronic-token/tx",
        validatorInfoRef = "https://chtd-api.skynetvalidators.com/staking/validators",
        isCosmosNetwork = true
    ),

    ASSET_MANTLE(
        title = "AssetMantle",
        landingRef = "https://assetmantle.one/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/19686.png",
        validatorsListRef = "asset-mantle".toExproleCosmosValidators(),
        getProposalsRef = "assetmantle".toGetCosmosProposals(),
        exploreProposalRef = "asset-mantle".toExploreCosmosProposals(),
        getTransactionsRef = "asset-mantle".toGetCosmosTransactions(),
        exploreTransactionRef = "asset-mantle".toExploreCosmosTransaction(),
        validatorInfoRef = "asset-mantle".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    FETCH_AI(
        title = "Fetch.ai",
        landingRef = "https://fetch-ai.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/3773.png",
        validatorsListRef = "fetchai".toExproleCosmosValidators(),
        getProposalsRef = "fetchai".toGetCosmosProposals(),
        exploreProposalRef = "fetchai".toExploreCosmosProposals(),
        getTransactionsRef = "fetchai".toGetCosmosTransactions(),
        exploreTransactionRef = "fetchai".toExploreCosmosTransaction(),
        validatorInfoRef = "fetchai".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    AKASH(
        title = "Akash",
        landingRef = "https://akash.network/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/7431.png",
        validatorsListRef = "akash".toExproleCosmosValidators(),
        getProposalsRef = "akash".toGetCosmosProposals(),
        exploreProposalRef = "akash".toExploreCosmosProposals(),
        getTransactionsRef = "akash".toGetCosmosTransactions(),
        exploreTransactionRef = "akash".toExploreCosmosTransaction(),
        validatorInfoRef = "akash".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    CERBERUS(
        title = "Cerberus",
        landingRef = "https://cerberus.zone/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/18900.png",
        validatorsListRef = "cerberus".toExproleCosmosValidators(),
        getProposalsRef = "cerberus".toGetCosmosProposals(),
        exploreProposalRef = "cerberus".toExploreCosmosProposals(),
        getTransactionsRef = "cerberus".toGetCosmosTransactions(),
        exploreTransactionRef = "cerberus".toExploreCosmosTransaction(),
        validatorInfoRef = "cerberus".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    CHIHUAHUA(
        title = "Chihuahua",
        landingRef = "https://www.chihuahua.wtf/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/17208.png",
        validatorsListRef = "chihuahua".toExproleCosmosValidators(),
        getProposalsRef = "chihuahua".toGetCosmosProposals(),
        exploreProposalRef = "chihuahua".toExploreCosmosProposals(),
        getTransactionsRef = "chihuahua".toGetCosmosTransactions(),
        exploreTransactionRef = "chihuahua".toExploreCosmosTransaction(),
        validatorInfoRef = "chihuahua".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    COMDEX(
        title = "Comdex",
        landingRef = "comdex.one/home",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/14713.png",
        validatorsListRef = "comdex".toExproleCosmosValidators(),
        getProposalsRef = "comdex".toGetCosmosProposals(),
        exploreProposalRef = "comdex".toExploreCosmosProposals(),
        getTransactionsRef = "comdex".toGetCosmosTransactions(),
        exploreTransactionRef = "comdex".toExploreCosmosTransaction(),
        validatorInfoRef = "comdex".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    CRYPTO_ORG(
        title = "Crypto.org",
        landingRef = "https://crypto.org/",
        imageRef = "https://avatars.githubusercontent.com/u/78834054?s=200&v=4",
        validatorsListRef = "cryptocom".toExproleCosmosValidators(),
        getProposalsRef = "crypto-org".toGetCosmosProposals(),
        exploreProposalRef = "crypto-org".toExploreCosmosProposals(),
        getTransactionsRef = "crypto-org".toGetCosmosTransactions(),
        exploreTransactionRef = "crypto-org".toExploreCosmosTransaction(),
        validatorInfoRef = "cryptocom".toGetCosmosValidator(),
        isCosmosNetwork = true
    ),

    DIG(
        title = "Dig",
        landingRef = "https://digchain.org/",
        imageRef = "https://s2.coinmarketcap.com/static/img/coins/64x64/17748.png",
        validatorsListRef = "https://ping.pub/dig/staking",
        isCosmosNetwork = false
    );


}