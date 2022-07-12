package com.mobileweb3.dvs.core.entity.proposal

import kotlinx.serialization.Serializable

@Serializable
data class Proposal(
    val id: Int,
    val tx_hash: String? = null,
    val proposer: String? = null,
    val title: String? = null,
    val description: String? = null,
    val proposal_type: String? = null,
    val proposal_status: String? = null,
    val submit_time: String? = null,
    val voting_start_time: String? = null,
    val voting_end_time: String? = null,
    val notification_status: String? = null,
    val content: Content? = null,
    val moniker: String? = null,
    val initial_deposit: Coin? = null,
    val total_deposit: List<Coin>? = null,
    val voteMeta: VoteMeta? = null,
    val yes: String? = null,
    val no: String? = null,
    val no_with_veto: String? = null,
    val abstain: String? = null,
) {

    fun getPercentages(): ProposalPercentages {
        val yesVotes = yes?.toDouble() ?: 0.0
        val noVotes = no?.toDouble() ?: 0.0
        val noWithVetoVotes = no_with_veto?.toDouble() ?: 0.0
        val abstainVotes = abstain?.toDouble() ?: 0.0
        val allVotes = yesVotes + noVotes + noWithVetoVotes + abstainVotes
        return ProposalPercentages(
            yes = 100 * (yesVotes / allVotes),
            no = 100 * (noVotes / allVotes),
            noWithVeto = 100 * (noWithVetoVotes / allVotes),
            abstain = 100 * (abstainVotes / allVotes)
        )
    }
}

data class ProposalPercentages(
    val yes: Double,
    val no: Double,
    val noWithVeto: Double,
    val abstain: Double
)

@Serializable
data class Content(
    val type: String? = null,
    val recipient: String? = null,
    val recipient_list: List<Recipient>? = null,
    val amount: ArrayList<Coin>? = null
)

@Serializable
data class Recipient(
    val amount: ArrayList<Coin>? = null
)

@Serializable
data class VoteMeta(
    val yes: String? = null,
    val no: String? = null,
    val no_with_veto: String? = null,
    val abstain: String? = null,
    val yes_amount: String? = null,
    val no_amount: String? = null,
    val no_with_veto_amount: String? = null,
    val abstain_amount: String? = null
)

@Serializable
data class Coin(
    val denom: String? = null,
    val amount: String? = null
)