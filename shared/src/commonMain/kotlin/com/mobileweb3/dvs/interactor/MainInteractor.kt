package com.mobileweb3.dvs.interactor

import com.mobileweb3.dvs.core.datasource.network.Api
import com.mobileweb3.dvs.core.datasource.storage.SomethingStorage
import com.mobileweb3.dvs.core.entity.network.MintScanExplorer
import com.mobileweb3.dvs.core.entity.network.NetworkExplorer
import com.mobileweb3.dvs.core.entity.network.PingPubExplorer
import com.mobileweb3.dvs.core.entity.transaction.PingPubTransactionsResponse
import com.mobileweb3.dvs.core.entity.transaction.Transaction
import com.mobileweb3.dvs.core.entity.transaction.TransactionData
import com.mobileweb3.dvs.core.entity.transaction.Tx
import com.mobileweb3.dvs.core.entity.validator.ValidatorInfo
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorVote
import com.mobileweb3.dvs.core.entity.validator.Vote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

class MainInteractor internal constructor(
    private val api: Api,
    private val somethingStorage: SomethingStorage,
) {
//
//    @Throws(Exception::class)
//    suspend fun getAllSomething(
//        forceUpdate: Boolean = false
//    ): List<Something> {
//        var somethings = somethingStorage.getAllSomething()
//
//        if (forceUpdate || somethings.isEmpty()) {
//            val new = api.getSomething("url").data
//            somethingStorage.saveSomething(new)
//            somethings = new
//        }
//
//        return somethings
//    }
//
//    @Throws(Exception::class)
//    suspend fun addSomething(url: String) {
//        val something = api.getSomething(url).data.firstOrNull()
//        something?.let { somethingStorage.saveSomething(it) }
//    }
//
//    @Throws(Exception::class)
//    suspend fun deleteSomething(id: String) {
//        somethingStorage.deleteSomething(id)
//    }

    suspend fun getValidatorVotes(
        validatorNetwork: ValidatorNetwork,
        coroutineScope: CoroutineScope
    ): List<ValidatorVote> {
        if (validatorNetwork.blockchainNetwork.networkExplorer != null && validatorNetwork.walletAddress != null) {
            return getValidatorVotesFromApi(validatorNetwork.blockchainNetwork.networkExplorer, validatorNetwork.walletAddress, coroutineScope)
        }

        if (validatorNetwork.blockchainNetwork.getProposalsRef == null) {
            return emptyList()
        }

        val proposals = withContext(coroutineScope.coroutineContext) {
            api.getProposals(validatorNetwork.blockchainNetwork)
        }
        val validatorTransactions: List<Transaction> = try {
            withContext(coroutineScope.coroutineContext) {
                api.getValidatorTransactions(validatorNetwork.getValidatorTransactionsLink())
            }
        } catch (ex: Exception) {
            emptyList()
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

    private suspend fun getValidatorVotesFromApi(
        networkExplorer: NetworkExplorer,
        validatorWalletAddress: String,
        coroutineScope: CoroutineScope
    ): List<ValidatorVote> {
        val proposals = withContext(coroutineScope.coroutineContext) {
            api.getProposalsNew(networkExplorer.getProposals())
        }
        val validatorTransactions: List<Transaction> = try {
            withContext(coroutineScope.coroutineContext) {
                if (networkExplorer is MintScanExplorer) {
                    api.getValidatorTransactionsNew<List<Transaction>>(networkExplorer.getTransactions(validatorWalletAddress))
                }

                if (networkExplorer is PingPubExplorer) {
                    val pingPubResponse = api.getValidatorTransactionsNew<PingPubTransactionsResponse>(networkExplorer.getTransactions(validatorWalletAddress))
                    pingPubResponse.tx_responses.map { Transaction(it) }
                }

                throw Exception("wft is explorer")
            }
        } catch (ex: Exception) {
            emptyList()
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

    suspend fun getValidatorInfo(network: ValidatorNetwork): ValidatorInfo {
        if (network.blockchainNetwork.networkExplorer != null && network.validatorAddress != null) {
            return api.getValidatorInfo(network.blockchainNetwork.networkExplorer.getValidatorInfo(network.validatorAddress))
        }

        return api.getValidatorInfo(network.getValidatorStatusLink())
    }

    companion object
}