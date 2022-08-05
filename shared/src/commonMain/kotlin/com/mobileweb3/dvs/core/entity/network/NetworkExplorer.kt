package com.mobileweb3.dvs.core.entity.network

interface NetworkExplorer {

    fun getValidatorInfo(validatorAddress: String): String

    fun exploreValidators(): String

    fun getProposals(): String

    fun exploreProposals(): String

    fun getTransactions(validatorWalletAddress: String): String

    fun exploreTransaction(): String
}

