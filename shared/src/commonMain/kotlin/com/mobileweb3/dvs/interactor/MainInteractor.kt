package com.mobileweb3.dvs.interactor

import com.mobileweb3.dvs.core.datasource.network.SomethingLoader
import com.mobileweb3.dvs.core.datasource.storage.SomethingStorage
import com.mobileweb3.dvs.core.entity.Something
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorVote
import com.mobileweb3.dvs.core.entity.validator.Vote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

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
        validatorNetwork: ValidatorNetwork,
        coroutineScope: CoroutineScope
    ): List<ValidatorVote> {
        if (validatorNetwork.blockchainNetwork.getProposalsRef == null) {
            return emptyList()
        }

        val proposals = withContext(coroutineScope.coroutineContext) {
            somethingLoader.getProposalsFromMintScan(validatorNetwork.blockchainNetwork.getProposalsRef)
        }
        val validatorTransactions = withContext(coroutineScope.coroutineContext) {
            somethingLoader.getValidatorTransactions(validatorNetwork.getValidatorTransactionsLink())
        }

        val resultList = mutableListOf<ValidatorVote>()
        val validatorVoteTransactions = validatorTransactions
            .filter { transaction -> transaction.data.tx.body.messages?.get(0)?.proposal_id != null }
            .filter { transaction -> transaction.data.raw_log != null && !transaction.data.raw_log.contains("fail") }

        proposals
            .sortedBy { it.id }
            .forEach { proposal ->
                val validatorVoteTransaction = validatorVoteTransactions.find { voteTransaction ->
                    val transactionMessage = voteTransaction.data.tx.body.messages!![0]
                    proposal.id.toString() == transactionMessage.proposal_id!!
                }

                val validatorVote = validatorVoteTransaction?.let {
                    Vote.from(it.data.tx.body.messages!![0].option)
                } ?: Vote.DID_NOT_VOTE

                resultList.add(
                    ValidatorVote(
                        proposal = proposal,
                        vote = validatorVote,
                        txhash = validatorVoteTransaction?.data?.txhash
                    )
                )
            }

        return resultList.sortedByDescending { it.proposal.id }
    }

    companion object
}