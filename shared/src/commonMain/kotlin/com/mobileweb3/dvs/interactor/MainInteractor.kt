package com.mobileweb3.dvs.interactor

import com.mobileweb3.dvs.core.datasource.network.SomethingLoader
import com.mobileweb3.dvs.core.datasource.storage.SomethingStorage
import com.mobileweb3.dvs.core.entity.Something
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorVote
import com.mobileweb3.dvs.core.entity.validator.Vote

class MainInteractor internal constructor(
    private val somethingLoader: SomethingLoader,
    private val somethingStorage: SomethingStorage,
) {

    @Throws(Exception::class)
    suspend fun getAllSomething(
        forceUpdate: Boolean = false
    ): List<Something> {
        var somethings = somethingStorage.getAllSomething()

        if (forceUpdate || somethings.isEmpty()) {
            val new = somethingLoader.getSomething("url").data
            somethingStorage.saveSomething(new)
            somethings = new
        }

        return somethings
    }

    @Throws(Exception::class)
    suspend fun addSomething(url: String) {
        val something = somethingLoader.getSomething(url).data.firstOrNull()
        something?.let { somethingStorage.saveSomething(it) }
    }

    @Throws(Exception::class)
    suspend fun deleteSomething(id: String) {
        somethingStorage.deleteSomething(id)
    }

    suspend fun getValidatorVotes(
        validatorNetwork: ValidatorNetwork
    ): List<ValidatorVote> {
        if (validatorNetwork.blockchainNetwork.proposalsRef == null) {
            return emptyList()
        }

        val proposals = somethingLoader.getProposalsFromMintScan(validatorNetwork.blockchainNetwork.proposalsRef)
        val validatorTransactions = somethingLoader.getValidatorTransactions(
            validatorNetwork.getValidatorTransactionsLink()
        )

        val resultList = mutableListOf<ValidatorVote>()
        validatorTransactions
            .filter { transaction -> transaction.data.tx.body.messages?.get(0)?.proposal_id != null }
            .filter { transaction -> transaction.data.raw_log != null && !transaction.data.raw_log.contains("fail") }
            .forEach { transaction ->
                val transactionMessage = transaction.data.tx.body.messages!![0]

                resultList.add(
                    0, ValidatorVote(
                        proposal = proposals.first { proposal -> proposal.id.toString() == transactionMessage.proposal_id!! },
                        vote = Vote.from(transactionMessage.option),
                        txhash = transaction.data.txhash
                    )
                )
            }

        return resultList.sortedByDescending { it.proposal.id }
    }

    companion object
}