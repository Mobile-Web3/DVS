package com.mobileweb3.dvs.core.entity.validator

import com.mobileweb3.dvs.core.entity.proposal.Proposal

data class ValidatorVote(
    val proposal: Proposal,
    val vote: Vote,
    val txhash: String
)

enum class Vote {
    YES,
    NO,
    NO_WITH_VETO,
    ABSTAIN,
    UNKNOWN;

    companion object {

        fun from(string: String?): Vote {
            return when (string) {
                "VOTE_OPTION_YES" -> YES
                "VOTE_OPTION_NO" -> NO
                "VOTE_OPTION_NO_WITH_VETO" -> NO_WITH_VETO
                "VOTE_OPTION_ABSTAIN" -> ABSTAIN
                else -> UNKNOWN
            }
        }
    }
}