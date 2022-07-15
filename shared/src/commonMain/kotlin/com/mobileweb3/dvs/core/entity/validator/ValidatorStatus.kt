package com.mobileweb3.dvs.core.entity.validator

enum class ValidatorStatus {
    ACTIVE,
    INACTIVE;

    companion object {
        fun from(status: Int?): String {
            return when (status) {
                //seems like 3 is active
                3 -> "ACTIVE"
                else -> "INACTIVE"
            }
        }
    }
}