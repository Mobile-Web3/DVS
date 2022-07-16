package com.mobileweb3.dvs.core.entity.proposal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ChronicProposals(
    val proposals: List<ChronicProposal>
)

internal fun ChronicProposals.toDefaultProposals(): List<Proposal> {
    return proposals.map { chronicProposal ->
        Proposal(
            id = chronicProposal.proposal_id.toInt(),
            title = chronicProposal.content.description,
            proposal_status = chronicProposal.status,
            yes = chronicProposal.voteResults.yes,
            no = chronicProposal.voteResults.no,
            no_with_veto = chronicProposal.voteResults.no_with_veto,
            abstain = chronicProposal.voteResults.abstain,
        )
    }
}

@Serializable
internal data class ChronicProposal(
    val proposal_id: String,
    val content: ChronicProposalContent,
    val status: String,
    @SerialName("final_tally_result")
    val voteResults: ChronicProposalVoteResult
)

@Serializable
internal data class ChronicProposalContent(
    val description: String
)

@Serializable
internal data class ChronicProposalVoteResult(
    val yes: String,
    val abstain: String,
    val no: String,
    val no_with_veto: String
)