package com.mobileweb3.dvs.core.entity.validator

import com.mobileweb3.dvs.core.entity.proposal.Proposal

data class ValidatorVote(
    val proposal: Proposal,
    val vote: Vote,
    val txhash: String
)

enum class Vote(val string: String, val color: Long) {
    YES("Yes", 0xff5FD68B),
    NO("No", 0xffef6767),
    NO_WITH_VETO("NoWithVeto", 0xffFF999A),
    ABSTAIN("Abstain", 0xff9FA4AD),
    UNKNOWN("Unknown", 0xff000000);

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