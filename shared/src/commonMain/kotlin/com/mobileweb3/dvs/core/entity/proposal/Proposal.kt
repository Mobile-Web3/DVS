package com.mobileweb3.dvs.core.entity.proposal

import kotlinx.serialization.Serializable

@Serializable
data class Proposal(
    val id: Int,
    val title: String? = null,
    val proposal_status: String? = null,
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