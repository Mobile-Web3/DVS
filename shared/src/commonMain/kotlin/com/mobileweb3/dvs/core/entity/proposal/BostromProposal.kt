package com.mobileweb3.dvs.core.entity.proposal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BostromProposals(
    val result: List<BostromProposal>
)

internal fun BostromProposals.toDefaultProposals(): List<Proposal> {
    return result.map { bostromProposal ->
        Proposal(
            id = bostromProposal.id.toInt(),
            title = bostromProposal.content.value.title,
            proposal_status = mapBostromStatusToProposalStatus(bostromProposal.status)
        )
    }
}

internal fun mapBostromStatusToProposalStatus(bostrom: Int): String {
    //need to know what other int statuses are
    return when (bostrom) {
        2 -> "PROPOSAL_STATUS_VOTING_PERIOD"
        3 -> "PROPOSAL_STATUS_PASSED"
        else -> "UNKNOWN"
    }
}

@Serializable
internal data class BostromProposal(
    val id: String,
    val content: BostromProposalContent,
    @SerialName("final_tally_result")
    val voteResults: BostromProposalVoteResult,
    val status: Int
)

@Serializable
internal data class BostromProposalContent(
    val value: BostromProposalContentValue
)

@Serializable
internal data class BostromProposalContentValue(
    val title: String,
    val description: String
)

@Serializable
internal data class BostromProposalVoteResult(
    val yes: String,
    val abstain: String,
    val no: String,
    val no_with_veto: String
)