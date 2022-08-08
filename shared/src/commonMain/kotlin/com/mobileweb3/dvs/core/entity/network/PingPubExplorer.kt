package com.mobileweb3.dvs.core.entity.network

class PingPubExplorer(val network: String) : NetworkExplorer {

    override fun getValidatorInfo(validatorAddress: String): String {
        return "https://rest.$network-apis.com/staking/validators/$validatorAddress"
    }

    override fun exploreValidators(): String {
        TODO("Not yet implemented")
    }

    override fun getProposals(): String {
        return ""
    }

    override fun exploreProposals(): String {
        TODO("Not yet implemented")
    }

    override fun getTransactions(validatorWalletAddress: String): String {
        return "https://rest.$network-apis.com/cosmos/tx/v1beta1/txs?events=message.sender='$validatorWalletAddress'"
    }

    override fun exploreTransaction(): String {
        TODO("Not yet implemented")
    }
}