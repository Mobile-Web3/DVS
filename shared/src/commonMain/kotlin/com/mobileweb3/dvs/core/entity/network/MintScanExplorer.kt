package com.mobileweb3.dvs.core.entity.network

class MintScanExplorer(val network: String) : NetworkExplorer {

    override fun getValidatorInfo(validatorAddress: String): String {
        return "https://api-$network.cosmostation.io/v1/staking/validator/$validatorAddress"
    }

    override fun exploreValidators(): String {
        return "https://www.mintscan.io/$network/validators"
    }

    override fun getProposals(): String {
        return "https://api.mintscan.io/v1/$network/proposals"
    }

    override fun exploreProposals(): String {
        return "https://www.mintscan.io/$network/proposals"
    }

    override fun getTransactions(validatorWalletAddress: String): String {
        return "https://api-$network.cosmostation.io/v1/account/new_txs/$validatorWalletAddress?limit=100&from=0"
    }

    override fun exploreTransaction(): String {
        return "https://www.mintscan.io/$network/txs"
    }
}