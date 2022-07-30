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

        if (allVotes == 0.0) {
            return ProposalPercentages(
                yes = 25.0,
                no = 25.0,
                noWithVeto = 25.0,
                abstain = 25.0
            )
        }

        val yesResult = 100 * (yesVotes / allVotes)
        val noResult = 100 * (noVotes / allVotes)
        val noWithVetoResult = 100 * (noWithVetoVotes / allVotes)
        val abstainResult = 100 * (abstainVotes / allVotes)

        return ProposalPercentages(
            yes = yesResult,
            no = noResult,
            noWithVeto = noWithVetoResult,
            abstain = abstainResult
        )
    }
}

data class ProposalPercentages(
    val yes: Double,
    val no: Double,
    val noWithVeto: Double,
    val abstain: Double
)