package com.mobileweb3.dvs.core.entity.validator

enum class ValidatorStatus {
    ACTIVE,
    INACTIVE;

    companion object {
        fun from(status: Int?): String {
            return when (status) {
                2 -> "JAILED"
                //seems like 3 is active
                3 -> "ACTIVE"
                null -> "UNKNOWN"
                else -> "INACTIVE"
            }
        }
    }
}