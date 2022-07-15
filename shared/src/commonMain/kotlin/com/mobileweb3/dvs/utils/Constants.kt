package com.mobileweb3.dvs.utils

import com.mobileweb3.dvs.utils.Constants.MINTSCAN_API_REF
import com.mobileweb3.dvs.utils.Constants.MINTSCAN_GET_TRX_END
import com.mobileweb3.dvs.utils.Constants.MINTSCAN_API_NETWORK_START
import com.mobileweb3.dvs.utils.Constants.MINTSCAN_REF
import com.mobileweb3.dvs.utils.Constants.MINTSCAN_VALIDATOR_INFO_END

internal object Constants {

    const val MINTSCAN_REF = "https://www.mintscan.io"
    const val MINTSCAN_API_REF = "https://api.mintscan.io/v1"
    const val MINTSCAN_API_NETWORK_START = "https://api-"
    const val MINTSCAN_GET_TRX_END = ".cosmostation.io/v1/account/new_txs"
    const val MINTSCAN_VALIDATOR_INFO_END = ".cosmostation.io/v1/staking/validator"
}

internal fun String.toCosmosValidators(): String {
    return "$MINTSCAN_REF/$this/validators"
}

internal fun String.toGetCosmosProposals(): String {
    return "$MINTSCAN_API_REF/$this/proposals"
}

internal fun String.toCosmosProposals(): String {
    return "$MINTSCAN_REF/$this/proposals"
}

internal fun String.toGetCosmosTransactions(): String {
    return "$MINTSCAN_API_NETWORK_START$this$MINTSCAN_GET_TRX_END"
}

internal fun String.toExploreCosmosTransaction(): String {
    return "$MINTSCAN_REF/$this/txs"
}

internal fun String.toGetCosmosValidator(): String {
    return "$MINTSCAN_API_NETWORK_START$this$MINTSCAN_VALIDATOR_INFO_END"
}