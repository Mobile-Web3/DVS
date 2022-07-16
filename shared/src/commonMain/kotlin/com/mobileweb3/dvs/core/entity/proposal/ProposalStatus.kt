package com.mobileweb3.dvs.core.entity.proposal

internal const val DEFAULT_PROPOSAL_STATUS_PASSED = "PROPOSAL_STATUS_PASSED"
internal const val PROPOSAL_STATUS_VOTING_PERIOD = "PROPOSAL_STATUS_VOTING_PERIOD"
internal const val PROPOSAL_STATUS_FAILED = "PROPOSAL_STATUS_FAILED"
internal const val PROPOSAL_STATUS_REJECTED = "PROPOSAL_STATUS_REJECTED"
internal const val PROPOSAL_STATUS_DEPOSIT_PERIOD = "PROPOSAL_STATUS_DEPOSIT_PERIOD"

enum class ProposalStatus(val title: String, val backgroundColor: Long, val textColor: Long) {
    PASSED("PASSED", 0xffEEFBF0, 0xff37CC6F),
    VOTING_PERIOD("VOTING PERIOD", 0xffEBF7FF, 0xff02B1FF),
    FAILED("FAILED", 0xffE2E2E2, 0xff898989),
    REJECTED("REJECTED", 0xffFFEBED, 0xffFF2745),
    DEPOSIT_PERIOD("DEPOSIT PERIOD", 0xfffef6ec, 0xfff3a52f),
    UNKNOWN("UNKNOWN", 0xffE2E2E2, 0xff898989);

    companion object {

        fun from(stringStatus: String?): ProposalStatus {
            return when (stringStatus) {
                "PROPOSAL_STATUS_PASSED" -> PASSED
                "PROPOSAL_STATUS_VOTING_PERIOD" -> VOTING_PERIOD
                "PROPOSAL_STATUS_FAILED" -> FAILED
                "PROPOSAL_STATUS_REJECTED" -> REJECTED
                "PROPOSAL_STATUS_DEPOSIT_PERIOD" -> DEPOSIT_PERIOD
                else -> UNKNOWN
            }
        }
    }
}